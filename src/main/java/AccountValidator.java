public class AccountValidator {

    public void validate(AccountValidationContext validationContext) {
        checkAccountUser(validationContext);
        checkAccountType(validationContext);
        checkAccountBalance(validationContext);
    }

    public void checkAccountUser(AccountValidationContext validationContext) {
        validationContext.setUserValid(true);
    }

    public void checkAccountType(AccountValidationContext validationContext) {
        validationContext.setAccountTypeValid(true);
    }

    public void checkAccountBalance(AccountValidationContext validationContext) {
        validationContext.setAccountBalanceValid(true);
    }
}
