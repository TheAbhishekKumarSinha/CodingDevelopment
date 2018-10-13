package designpattern.behavioral.visitor;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class ShoppingCartCosts {
    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[] { new Book("1234", 20), new Book("5678", 100), new Fruits(10, 2, "Banana"),
                new Fruits(5, 5, "Apple") };

        int total = calculatePrice(items);
        System.out.println("Total Cost = " + total);
    }

    private static int calculatePrice(ItemElement[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (ItemElement item : items) {
            sum = sum + item.accept(visitor);
        }
        return sum;
    }
}
