package designpattern.behavioral.visitor;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class Book implements ItemElement {
    private String bookNumber;
    private int bookPrice;

    /**
     * @param bookNumber
     * @param bookPrice
     */
    public Book(String bookNumber, int bookPrice) {
        super();
        this.bookNumber = bookNumber;
        this.bookPrice = bookPrice;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);

    }

}
