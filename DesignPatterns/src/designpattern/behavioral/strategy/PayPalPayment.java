package designpattern.behavioral.strategy;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class PayPalPayment implements PaymentStrategy {

    private String emailId;
    private String password;

    public PayPalPayment(String emailId, String password) {
        super();
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Amount: " + amount + " paid by Pay Pal Account: " + this.emailId);

    }

}
