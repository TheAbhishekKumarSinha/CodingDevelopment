package hibernateproject.hibernate.comparator;

import java.util.Comparator;

import hibernateproject.hibernate.pojo.Items;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class PriceComparator implements Comparator<Items> {

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Items o1, Items o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }

}
