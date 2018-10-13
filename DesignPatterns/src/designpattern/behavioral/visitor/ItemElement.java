package designpattern.behavioral.visitor;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public interface ItemElement {
    public int accept(ShoppingCartVisitor visitor);
}
