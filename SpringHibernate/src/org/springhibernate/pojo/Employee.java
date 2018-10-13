package org.springhibernate.pojo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Abhishek Kumar Sinha
 * @Column(name = "ID", nullable = false, length = 15)
 */
@Entity
@Table(name = "Employee")
public class Employee {
    @EmbeddedId
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "CustId", nullable = false, length = 15)
    private String CustomerId;

    @EmbeddedId
    @Column(unique = true, name = "CustName", nullable = false, length = 15)
    private String CustomerName;

    @Column(name = "ROLE", length = 20, nullable = true)
    private String role;

    @Column(name = "insert_time", nullable = true)
    private Date insertTime;

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

}
