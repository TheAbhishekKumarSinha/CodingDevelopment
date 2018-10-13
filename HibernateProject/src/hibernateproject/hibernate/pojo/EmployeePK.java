package hibernateproject.hibernate.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Abhishek Kumar Sinha
 *
 */
@Embeddable
public class EmployeePK implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "CustId", nullable = false, length = 15)
    private String CustomerId;

    @Column(unique = true, name = "CustName", nullable = false, length = 15)
    private String CustomerName;

    /**
     * @param customerId
     * @param customerName
     */
    public EmployeePK(String customerId, String customerName) {
        super();
        CustomerId = customerId;
        CustomerName = customerName;
    }

    protected String getCustomerId() {
        return CustomerId;
    }

    protected void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    protected String getCustomerName() {
        return CustomerName;
    }

    protected void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    @Override
    public String toString() {
        return "Customer ID: " + CustomerId + "Customer Name: " + CustomerName;

    }
}
