package hibernateproject.hibernate.mapping.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateproject.hibernate.pojo.Customer;
import hibernateproject.hibernate.pojo.Transactions;
import hibernateproject.hibernate.util.HibernateUtil;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class HibernateOneToOneAnnotation {

    public static void main(String[] args) {

        Customer txn = buildDemoTransaction();

        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = null;
        Transaction tx = null;
        try {
            // Get Session

            session = HibernateUtil.getCurrentSession();
            System.out.println("Session created using annotations configuration");
            // start transaction
            tx = session.beginTransaction();
            // Save the Model object
            session.save(txn);
            // Commit transaction
            tx.commit();
            System.out.println("Annotation Example. Transaction ID=" + txn.getCustomerCode());

            // Get Saved Trasaction Data
            printTransactionData(txn.getCustomerCode(), sessionFactory);

        }
        catch (Exception e) {
            System.out.println("Exception occured. " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            if (sessionFactory != null && !sessionFactory.isClosed()) {
                System.out.println("Closing SessionFactory");
                sessionFactory.close();
            }
        }
    }

    private static void printTransactionData(String id, SessionFactory sessionFactory) {
        Session session = null;
        Transaction tx = null;
        try {
            // Get Session
            session = HibernateUtil.getCurrentSession();

            // start transaction
            tx = session.beginTransaction();
            // Save the Model object
            Customer txn = (Customer) session.get(Customer.class, id);
            // Commit transaction
            tx.commit();
            System.out.println("Annotation Example. Transaction Details=\n" + txn);

        }
        catch (Exception e) {
            System.out.println("Exception occured. " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Customer buildDemoTransaction() {
        Transactions txn = new Transactions();
        txn.setTransactionId("XYZZZ");
        txn.setTransactionDate(new java.sql.Date(0));
        txn.setTransactionAmount(100D);

        Customer cust = new Customer();
        /*
         * cust.setAddress("San Jose, USA"); cust.setEmail("pankaj@yahoo.com");
         * cust.setName("Pankaj Kr");
         */

        cust.setCustomerCode("ABH001");
        cust.setCustomerName("Abhishek Kumar Sinha");
        cust.setCustType("Personal");
        cust.setTransaction(txn);
        txn.setCustomer(cust);

        return cust;
    }

}