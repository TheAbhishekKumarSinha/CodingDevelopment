package hibernateproject.hibernate.mapping.main;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateproject.hibernate.pojo.Cart;
import hibernateproject.hibernate.pojo.Items;
import hibernateproject.hibernate.util.HibernateUtil;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class HibernateOneToManyAnnotations {
    public static void main(String[] args) {
        Cart cart = buildCartDetails();
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.save(cart);
        tx.commit();
        printCartDetails(cart.getCartId());

        addItemToCart(cart.getCartId());

        printCartDetails(cart.getCartId());

    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @param
     */
    private static void addItemToCart(String cartId) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Cart cart = (Cart) session.get(Cart.class, cartId);

        Set<Items> item = cart.getItems();
        Items itemValue = new Items();
        itemValue.setCart(cart);
        itemValue.setItemId("ASFDHS##");
        itemValue.setPrice(12.12);
        itemValue.setQuantity(2);
        item.add(itemValue);

        double d = 0.0;
        for (Items items : cart.getItems())
            d += items.getPrice() * items.getQuantity();
        cart.setTotalPrice(d);

        transaction.commit();

    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @param cartId
     */
    private static Cart printCartDetails(String cartId) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Cart cart = (Cart) session.get(Cart.class, cartId);

        System.out.println("Cart Details:");
        System.out.println("Cart Id " + cart.getCartId() + " Customer Code: " + cart.getCustomerId() + " Total Price: "
                + cart.getTotalPrice());
        int count = 0;
        for (Items item : cart.getItems()) {
            System.out.println("Item Details:");
            System.out.println("Item" + ++count + ": Item Code " + item.getItemId() + " Item Price: " + item.getPrice()
                    + "Item Quantity: " + item.getQuantity());
        }
        transaction.commit();
        return cart;
    }

    public static Cart buildCartDetails() {

        Cart cart = new Cart();
        Items item1 = new Items();
        item1.setCart(cart);
        item1.setItemId("AXS45SS");
        item1.setPrice(10.99);
        item1.setQuantity(2);

        Items item2 = new Items();
        item2.setCart(cart);
        item2.setItemId("ASDFER234");
        item2.setPrice(29.99);
        item2.setQuantity(1);

        SortedSet<Items> items = new TreeSet<>();
        items.add(item1);
        items.add(item2);

        cart.setCartId("CART_01");
        cart.setCustomerId("ABH001");
        double d = 0.0;
        for (Items item : items)
            d += item.getPrice() * item.getQuantity();
        cart.setTotalPrice(d);
        cart.setItems(items);

        return cart;
    }
}
