package designpattern.behavioral.visitor;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

    /*
     * (non-Javadoc)
     * 
     * @see
     * designpattern.behavioral.visitor.ShoppingCartVisitor#visit(designpattern.behavioral.visitor.
     * Book)
     */
    @Override
    public int visit(Book book) {
        if (book != null) {
            System.out.println("Book Number:" + book.getBookNumber() + " of Price : " + book.getBookPrice());
            if (book.getBookPrice() > 50) {
                book.setBookPrice(book.getBookPrice() - 5);
                return book.getBookPrice();
            }
            else {
                return book.getBookPrice();
            }
        }
        return 0;

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * designpattern.behavioral.visitor.ShoppingCartVisitor#visit(designpattern.behavioral.visitor.
     * Fruits)
     */
    @Override
    public int visit(Fruits fruit) {

        if (fruit != null) {
            System.out.println(" Fruit Name: " + fruit.getFruitName() + " Fruit Weight: " + fruit.getFruitWeight()
                    + " Fruit Price :" + fruit.getKg());
            return (int) (fruit.getFruitWeight() * fruit.getKg());
        }
        return 0;

    }

}
