package hibernateproject.hibernate.mapping.main;

import java.util.Date;

import org.hibernate.Session;

import hibernateproject.hibernate.pojo.Employee;
import hibernateproject.hibernate.pojo.EmployeePK;
import hibernateproject.hibernate.util.HibernateUtil;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class HibernateMain {

    public static void main(String[] args) {
        Employee emp = new Employee();
        EmployeePK empPk = new EmployeePK("12344", "Abhishek");
        emp.setEmployeePK(empPk);
        emp.setRole("CEO");
        emp.setInsertTime(new java.sql.Date(new Date().getTime()));

        // Get Session
        Session session = HibernateUtil.getCurrentSession();
        // start transaction
        session.beginTransaction();
        // Save the Model object
        session.save(emp);
        // Commit transaction
        session.getTransaction().commit();
        System.out.println(emp.getEmployeePK());

        session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        Employee emp1 = (Employee) session.load(Employee.class, empPk);
        emp1.setRole("Developer");

        System.out.println(emp.getEmployeePK());

        session.getTransaction().commit();
        // terminate session factory, otherwise program won't end
        HibernateUtil.getSessionAnnotationFactory().close();
    }

}
