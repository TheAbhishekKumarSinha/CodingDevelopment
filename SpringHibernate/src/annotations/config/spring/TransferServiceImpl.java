package annotations.config.spring;

import java.math.BigDecimal;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class TransferServiceImpl implements TransferService {

    /**
     * @param accountRepository
     */
    public TransferServiceImpl(AccountRepository accountRepository) {
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see abhi.ipl.team.controller.TransferService#transfer(java.math.BigDecimal,
     * java.lang.String, java.lang.String)
     */
    @Override
    public void transfer(BigDecimal amount, String Account1, String Account2) {
        System.out.println("Amount Rs: " + amount + " Transferred from Account " + Account1 + " to Account :" + Account2);

    }

}
