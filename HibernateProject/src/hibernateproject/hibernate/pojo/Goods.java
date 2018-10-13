package hibernateproject.hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Abhishek Kumar Sinha
 *
 */

@Entity
@Table(name = "GOODS")
public class Goods {
    @Id
    @Column(name = "GOOD_CODE", nullable = false)
    private String goodCode;

    @Column(name = "GOOD_DESC", nullable = false)
    private String goodDescription;

    @Column(name = "GOOD_PRICE", nullable = false)
    private double goodPrice;

    @Column(name = "GOOD_AVAILABLE_QUANTITY", nullable = false)
    private int availableQuantity;

    /**
     * @param goodCode
     * @param goodDescription
     * @param goodPrice
     * @param availableQuantity
     */
    public Goods(String goodCode, String goodDescription, double goodPrice, int availableQuantity) {
        super();
        this.goodCode = goodCode;
        this.goodDescription = goodDescription;
        this.goodPrice = goodPrice;
        this.availableQuantity = availableQuantity;
    }

    public Goods() {
        super();
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getGoodDescription() {
        return goodDescription;
    }

    public void setGoodDescription(String goodDescription) {
        this.goodDescription = goodDescription;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

}
