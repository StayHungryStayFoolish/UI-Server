package ink.bonismo.config;

import liquibase.integration.spring.SpringLiquibase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import javax.sql.DataSource;

/**
 * Created by bonismo@hotmail.com on 2019/3/19 3:11 PM
 *
 * @Description:
 * @Version: 1.0
 */
@Configuration
public class LiquibaseConfiguration {

    private final Logger logger = LoggerFactory.getLogger(LiquibaseConfiguration.class);

    private final static String SPRING_PROFILE_NO_LIQUIBASE = "no-liquibase";

    private final Environment env;

    public LiquibaseConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        if (env.acceptsProfiles(SPRING_PROFILE_NO_LIQUIBASE)) {
            liquibase.setShouldRun(false);
        } else {
            liquibase.setShouldRun(true);
            logger.debug("Configuring Liquibase");
        }
        return liquibase;
    }
}
