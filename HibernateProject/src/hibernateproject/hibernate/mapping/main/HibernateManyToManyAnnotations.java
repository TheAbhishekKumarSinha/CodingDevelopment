package hibernateproject.hibernate.mapping.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateproject.hibernate.pojo.Goods;
import hibernateproject.hibernate.pojo.Vendor;
import hibernateproject.hibernate.util.HibernateUtil;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class HibernateManyToManyAnnotations {
    public static void main(String[] args) {

        List<Vendor> vendor = buildVendorGoodsDetails();
        for (Vendor vend : vendor)
            printVendorItemDetails(vend.getVendorCode());
        Goods good = new Goods("GOODS04", "IPhone 9", 40000D, 12);
        for (Vendor vend : vendor)
            updateGoodsForAVendor(vend.getVendorCode(), good);

        for (Vendor vend : vendor)
            printVendorItemDetails(vend.getVendorCode());
    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @param vendorCode
     * @param good
     */
    private static void updateGoodsForAVendor(String vendorCode, Goods good) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Vendor vendor = (Vendor) session.get(Vendor.class, vendorCode);

        vendor.getGoods().add(good);
        int available = 0;
        for (Goods goodin : vendor.getGoods()) {
            available += goodin.getAvailableQuantity();
        }
        vendor.setVendorQuantity(available);
        session.save(vendor);

        transaction.commit();
    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     */
    private static void printVendorItemDetails(String vendorCode) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Vendor vendor = (Vendor) session.get(Vendor.class, vendorCode);

        System.out.println("Vendor Details:");
        System.out.println("Vendor Id " + vendor.getVendorCode() + " Vendor Name: " + vendor.getVendorName() + " Total Quantity: "
                + vendor.getVendorQuantity());
        int count = 0;
        for (Goods item : vendor.getGoods()) {
            System.out.println("Goods Details:");
            System.out.println("Good" + ++count + ": Good Code " + item.getGoodCode() + " Good Price: " + item.getGoodPrice()
                    + "Item Quantity: " + item.getAvailableQuantity());
        }
        transaction.commit();

    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @return
     */
    private static List<Vendor> buildVendorGoodsDetails() {
        Session session = HibernateUtil.getCurrentSession();
        Transaction trans = session.beginTransaction();

        Goods good = new Goods("GOOD01", "IPhoneX", 70000D, 10);
        Goods good1 = new Goods("GOOD02", "IPhone6", 36000D, 10);
        Goods good2 = new Goods("GOOD03", "IPhone8", 42000D, 10);

        Set<Goods> goods = new HashSet<>();
        goods.add(good);
        goods.add(good1);
        int avilable = 0;
        for (Goods goodin : goods) {
            avilable += goodin.getAvailableQuantity();
        }
        Vendor vendor = new Vendor("VEND01", "Vendor Kishore", avilable, goods);

        Set<Goods> goods1 = new HashSet<>();
        goods1.add(good);
        goods1.add(good2);
        avilable = 0;
        for (Goods goodin : goods1) {
            avilable += goodin.getAvailableQuantity();
        }
        Vendor vendor1 = new Vendor("VEND02", "Vendor Mahendra", avilable, goods1);

        session.save(vendor);
        session.save(vendor1);

        List<Vendor> list = new ArrayList<Vendor>();
        list.add(vendor);
        list.add(vendor1);

        trans.commit();

        return list;

    }
}
