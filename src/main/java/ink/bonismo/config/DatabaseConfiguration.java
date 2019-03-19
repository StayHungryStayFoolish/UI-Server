package ink.bonismo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by bonismo@hotmail.com on 2019/3/19 5:29 PM
 *
 * @Description:
 * @Version: 1.0
 */
@Configuration
@EnableJpaRepositories("ink.bonismo.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {
}
