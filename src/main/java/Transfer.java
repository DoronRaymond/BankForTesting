import java.util.Date;

public class Transfer {

    private String sendingAccount;

    private String receivingAccount;

    private double amount;

    private Date timestamp;

    public Transfer(String sendingAccount, String receivingAccount, double amount, Date timestamp) {
        this.sendingAccount = sendingAccount;
        this.receivingAccount = receivingAccount;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getSendingAccount() {
        return sendingAccount;
    }

    public String getReceivingAccount() {
        return receivingAccount;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
