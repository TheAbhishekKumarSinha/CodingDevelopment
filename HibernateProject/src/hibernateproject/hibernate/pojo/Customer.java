package hibernateproject.hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * @author Abhishek Kumar Sinha
 *
 */

@Entity
@Table(name = "CUSTOMER")

public class Customer {

    @Id
    @Column(name = "custCode", length = 20, nullable = false)
    private String customerCode;

    @Column(name = "customerName", length = 20, nullable = true)
    private String customerName;

    @Column(name = "custType", length = 20, nullable = true)
    private String custType;

    @OneToOne(mappedBy = "customer")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Transactions transaction;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public Transactions getTransaction() {
        return transaction;
    }

    public void setTransaction(Transactions transaction) {
        this.transaction = transaction;
    }

}
