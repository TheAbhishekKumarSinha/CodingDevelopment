package designpattern.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class ShoppingCart {
    List<Item> item = null;

    /**
     * 
     */
    public ShoppingCart() {
        item = new ArrayList<Item>();
    }

    public void add(Item item) {
        this.item.add(item);
    }

    public int calculateTotalAmount() {
        int amount = 0;
        for (Item it : item) {
            amount += Integer.parseInt(it.getPrice());
        }
        return amount;
    }

    public void payment(PaymentStrategy ps) {
        ps.pay(this.calculateTotalAmount());
    }
}
