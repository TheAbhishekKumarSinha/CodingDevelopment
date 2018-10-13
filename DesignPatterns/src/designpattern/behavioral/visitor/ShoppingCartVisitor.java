package designpattern.behavioral.visitor;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public interface ShoppingCartVisitor {

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @param book
     * @return
     */
    int visit(Book book);

    int visit(Fruits fruit);

}
