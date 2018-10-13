package designpattern.behavioral.strategy;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class Payment {
    public static void main(String[] args) {
        Item item1 = new Item("XXSDFE", "10");
        Item item2 = new Item("SGDKFFS", "17");

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(item1);
        shoppingCart.add(item2);

        PaymentStrategy ps = new CreditCardPayment("1234567890123456", "456", "Abhishek", "1234");

        shoppingCart.payment(ps);
        ps = new PayPalPayment("abcd@efg.com", "passwrd12");

        shoppingCart.payment(ps);
    }
}
