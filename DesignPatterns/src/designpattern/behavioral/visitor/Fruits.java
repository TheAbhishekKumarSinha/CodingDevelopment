package designpattern.behavioral.visitor;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class Fruits implements ItemElement {

    private float fruitWeight;
    private int kg;
    private String fruitName;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    /**
     * @param fruitWeight
     * @param kg
     * @param string
     */
    public Fruits(float fruitWeight, int kg, String fruitName) {
        super();
        this.fruitWeight = fruitWeight;
        this.kg = kg;
        this.fruitName = fruitName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.visitor.ItemElement#accept(designpattern.behavioral.visitor.
     * ShoppingCartVisitor)
     */
    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);

    }

    public float getFruitWeight() {
        return fruitWeight;
    }

    public void setFruitWeight(float fruitWeight) {
        this.fruitWeight = fruitWeight;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

}
