package designpattern.behavioral.strategy;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cvvCode;
    private String cardHolderName;
    private String pin;

    /**
     * @param cardNumber
     * @param cvvCode
     * @param cardHolderName
     * @param pin
     */
    public CreditCardPayment(String cardNumber, String cvvCode, String cardHolderName, String pin) {
        super();
        this.cardNumber = cardNumber;
        this.cvvCode = cvvCode;
        this.cardHolderName = cardHolderName;
        this.pin = pin;
    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.strategy.PaymentStrategy#pay(int)
     */
    @Override
    public void pay(int amount) {
        System.out.println("Amount: " + amount + " paid by Credit Card Account Holder: " + this.cardHolderName);

    }

}
