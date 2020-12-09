import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class Bank {

    private Set<Account> accounts;

    private AccountRepository accountRepository;

    private AccountValidator accountValidator;

    @Autowired
    public Bank(AccountRepository accountRepository, AccountValidator accountValidator) {
        accounts = new HashSet<>();
        this.accountRepository = accountRepository;
        this.accountValidator = accountValidator;
    }

    public void createCheckingAccount(int userId, double balance) {
        CheckingAccount account = new CheckingAccount(UUID.randomUUID().toString(), userId, balance);
        saveNewAccount(account);
    }

    public void createDepositAccount(int userId, double balance, double interest, Date releaseDate) {
        DepositAccount account = new DepositAccount(UUID.randomUUID().toString(), userId, balance, interest, releaseDate);
        saveNewAccount(account);
    }

    private void saveNewAccount(Account account) {
        this.accountRepository.save(account);
        accounts.add(account);
        account.applyThemeInSite();
    }

    public boolean validateAccount(Account account) {
        AccountValidationContext validationContext = new AccountValidationContext(account);
        accountValidator.validate(validationContext);

        return validationContext.isUserValid() &&
                validationContext.isAccountTypeValid() &&
                validationContext.isAccountBalanceValid();
    }

    public Set<Account> getAccounts() {
        return accounts;
    }
}
