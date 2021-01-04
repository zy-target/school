package school.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    public DataSourceConfig() {
    }

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setMinimumIdle(env.getProperty("spring.datasource.hikari.minimum-idle", Integer.TYPE));
        dataSource.setIdleTimeout((long)(Integer)env.getProperty("spring.datasource.hikari.idle-timeout", Integer.TYPE));
        dataSource.setMaximumPoolSize(this.env.getProperty("spring.datasource.hikari.maximum-pool-size", Integer.TYPE));
        dataSource.setAutoCommit(true);
        dataSource.setMaxLifetime((long)(Integer)env.getProperty("spring.datasource.hikari.max-lifetime", Integer.TYPE));
        dataSource.setConnectionTimeout((long)(Integer)env.getProperty("spring.datasource.hikari.connection-timeout", Integer.TYPE));
        dataSource.setConnectionTestQuery("SELECT 1");
        return dataSource;
    }
}