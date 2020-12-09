
public class CheckingAccount extends Account {

    public CheckingAccount(String id, int userId, double balance) {
        super(id, AccountType.CHECKING_ACCOUNT, userId, balance);
    }

    @Override
    public void applyThemeInSite() {
        throw new RuntimeException("Can't apply theme at the moment...");
    }
}
