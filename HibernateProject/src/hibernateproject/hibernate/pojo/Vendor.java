package hibernateproject.hibernate.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Abhishek Kumar Sinha
 *
 */
@Entity
@Table(name = "VENDOR")
public class Vendor {
    @Id
    @Column(name = "VENDOR_CODE", nullable = false)
    private String vendorCode;
    @Column(name = "VENDOR_NAME", nullable = false)
    private String vendorName;
    @Column(name = "VENDOR_QUANTITY", nullable = false)
    private int VendorQuantity;

    @JoinTable(name = "GOOD_VENDORS", joinColumns = { @JoinColumn(name = "VENDOR_CODE") }, inverseJoinColumns = {
            @JoinColumn(name = "GOOD_CODE") })
    @ManyToMany(targetEntity = Goods.class, cascade = CascadeType.ALL)
    private Set<Goods> goods;

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public int getVendorQuantity() {
        return VendorQuantity;
    }

    public void setVendorQuantity(int vendorQuantity) {
        this.VendorQuantity = vendorQuantity;
    }

    public Set<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Set<Goods> goods) {
        this.goods = goods;
    }

    /**
     * @param vendorCode
     * @param vendorName
     * @param vendorQuantity
     * @param goods
     */
    public Vendor(String vendorCode, String vendorName, int vendorQuantity, Set<Goods> goods) {
        super();
        this.vendorCode = vendorCode;
        this.vendorName = vendorName;
        this.VendorQuantity = vendorQuantity;
        this.goods = goods;
    }

    public Vendor() {
        super();
    }
}
