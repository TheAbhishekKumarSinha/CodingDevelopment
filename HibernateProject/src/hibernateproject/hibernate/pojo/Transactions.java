package hibernateproject.hibernate.pojo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Abhishek Kumar Sinha
 *
 */
@Entity
@Table(name = "TRANSACTION")
public class Transactions {
    @Id
    @Column(name = "txnId", unique = true, nullable = false)

    private String transactionId;

    @Column(name = "txnAmount", nullable = false)
    private Double transactionAmount;

    @Column(name = "txnDate", nullable = false)
    private Date transactionDate;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Customer customer;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
