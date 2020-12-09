import java.util.Date;

public abstract class Account {

    private String accountId;

    private AccountType accountType;

    private int userId;

    private double balance;

    private Date openingDate;

    public Account(String accountId, AccountType accountType, int userId, double balance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.userId = userId;
        this.balance = balance;
        this.openingDate = new Date();
    }

    public abstract void applyThemeInSite();

    public String getAccountId() {
        return accountId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public int getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getOpeningDate() {
        return openingDate;
    }
}
