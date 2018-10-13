package hibernateproject.hibernate.pojo;

import java.util.Set;
import java.util.SortedSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.SortComparator;

import hibernateproject.hibernate.comparator.PriceComparator;

/**
 * @author Abhishek Kumar Sinha
 *
 */
@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @Column(name = "CART_CODE", nullable = false, length = 15)
    private String cartId;

    @Column(name = "CUSTOMER_CODE", nullable = false, length = 15)
    private String customerId;

    @Column(name = "TOTAL_AMOUNT", nullable = false, length = 15)
    private double totalPrice;

    @OneToMany(mappedBy = "cart")
    @Cascade(value = CascadeType.ALL)
    @SortComparator(value = PriceComparator.class)
    private SortedSet<Items> items;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(SortedSet<Items> items) {
        this.items = items;
    }

}
