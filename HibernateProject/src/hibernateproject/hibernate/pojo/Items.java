package hibernateproject.hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Abhishek Kumar Sinha
 *
 */
@Entity
@Table(name = "ITEMS")
public class Items implements Comparable<Items> {

    @Id
    @Column(name = "ITEM_CODE")
    private String itemId;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "PRICE")
    private double price;

    @ManyToOne
    @JoinColumn(nullable = false, name = "CART_CODE")
    private Cart cart;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Items o) {
        if (o == null) {
            return -1;
        }

        if (this.getPrice() < o.getPrice())
            return -1;
        else if (this.getPrice() > o.getPrice())
            return 1;
        return 0;
    }

}
