package designpattern.behavioral.strategy;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class Item {

    String zipCode;
    String price;

    /**
     * @param zipCode
     * @param price
     */
    public Item(String zipCode, String price) {
        super();
        this.zipCode = zipCode;
        this.price = price;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
