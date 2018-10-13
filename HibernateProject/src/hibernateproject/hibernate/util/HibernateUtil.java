package hibernateproject.hibernate.util;

import java.io.File;

import org.hibernate.Session;
/**
 * @author Abhishek Kumar Sinha
 *
 */
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import hibernateproject.hibernate.pojo.Cart;
import hibernateproject.hibernate.pojo.Customer;
import hibernateproject.hibernate.pojo.Employee;
import hibernateproject.hibernate.pojo.Goods;
import hibernateproject.hibernate.pojo.Items;
import hibernateproject.hibernate.pojo.Transactions;
import hibernateproject.hibernate.pojo.Vendor;

public class HibernateUtil {

    // Annotation based configuration
    private static SessionFactory sessionAnnotationFactory;

    private static SessionFactory buildSessionAnnotationFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();

            String hibernatePropsFilePath = "src/hibernateproject/hibernate/util/hibernate-annotation.cfg.xml";
            File file = new File(hibernatePropsFilePath);
            configuration.configure(file);

            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(Transactions.class);
            configuration.addAnnotatedClass(Cart.class);
            configuration.addAnnotatedClass(Items.class);
            configuration.addAnnotatedClass(Vendor.class);
            configuration.addAnnotatedClass(Goods.class);

            System.out.println("Hibernate Annotation Configuration loaded");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                    .build();
            System.out.println("Hibernate Annotation serviceRegistry created");

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionAnnotationFactory() {
        if (sessionAnnotationFactory == null)
            sessionAnnotationFactory = buildSessionAnnotationFactory();
        return sessionAnnotationFactory;
    }

    public static Session getNewSession() {
        Session session = getSessionAnnotationFactory().openSession();

        return session;

    }

    public static Session getCurrentSession() {
        Session session = getSessionAnnotationFactory().getCurrentSession();

        return session;
    }

}
