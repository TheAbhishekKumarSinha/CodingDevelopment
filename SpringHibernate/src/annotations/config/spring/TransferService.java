package annotations.config.spring;

import java.math.BigDecimal;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public interface TransferService {
    public void transfer(BigDecimal amount, String Account1, String Account2);
}
