import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Service
public class TransferService {

    private Bank bank;

    @Autowired
    public TransferService(Bank bank) {
        this.bank = bank;
    }

    public Transfer createTransfer(String sendingAccount, String receivingAccount, double amount, Date timestamp) {
        Optional<Account> account = bank.getAccounts().stream().filter(acc -> sendingAccount.equals(acc.getAccountId())).findFirst();
        if (!account.isPresent() || AccountType.DEPOSIT_ACCOUNT.equals(account.get().getAccountType())) {
            throw new RuntimeException("SendingAccount is invalid");
        }

        return new Transfer(sendingAccount, receivingAccount, amount, timestamp);
    }

    public Account releaseDeposit(String accountId) {
        Optional<Account> account = bank.getAccounts().stream().filter(acc -> accountId.equals(acc.getAccountId())).findFirst();

        if (!account.isPresent() || !AccountType.DEPOSIT_ACCOUNT.equals(account.get().getAccountType())) {
            throw new RuntimeException("Account is not a deposit account");
        }

        DepositAccount depositAccount = (DepositAccount)account.get();

        long periodInDays = ChronoUnit.DAYS.between(LocalDateTime.now(), depositAccount.getOpeningDate().toInstant());
        double periodInYears = periodInDays == 0 ? 0 : (double)periodInDays / 365;
        double newBalance = depositAccount.getBalance() * (1 + depositAccount.getInterest() * periodInYears);

        if (depositAccount.getReleaseDate().compareTo(new Date()) > 0) {
            newBalance *= 0.80;
        }

        depositAccount.setBalance(newBalance);

        // Releasing account logic...

        return depositAccount;
    }
}
