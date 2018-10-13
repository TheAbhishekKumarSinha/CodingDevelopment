package annotations.config.spring;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author Abhishek Kumar Sinha
 *
 */

@Component
class ServiceConfig {
    @Autowired
    private RepositoryConfig repositoryConfig;

    @Bean
    public TransferService transferService() {
        return new TransferServiceImpl(repositoryConfig.accountRepository());
    }
}

@Component
interface RepositoryConfig {
    @Bean
    AccountRepository accountRepository();

    ProxyFactory proxyfactory = new ProxyFactory(TransferService.class);
}

@Component
class DefaultRepositoryConfig implements RepositoryConfig {
    @Bean
    public AccountRepository accountRepository() {
        return new JdbcAccountRepository();
    }
}

@Configuration
@Import({ ServiceConfig.class, DefaultRepositoryConfig.class }) // import the concrete config!
class SystemTestConfig {
    @Bean
    public DataSource dataSource() {
        return null;
        // return DataSource
    }

}

public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemTestConfig.class);
        TransferService transferService = ctx.getBean(TransferService.class);
        transferService.transfer(BigDecimal.valueOf(100.00), "A123", "C456");
    }
}
