package com.akash.github.springdatajpamysql.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.akash.github.springdatajpamysql.db.repositories"},
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager")
public class DataSourceConfiguration {

    @Resource(name = "configurationProperties")
    private ConfigurationProperties configurationProperties;

    @Bean
    public DataSource dataSource() {

        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setUrl(configurationProperties.getDatabaseConfiguration().getEndpoint());
        poolProperties.setDriverClassName(configurationProperties.getDatabaseConfiguration().getDriverClassName());
        poolProperties.setUsername(configurationProperties.getDatabaseConfiguration().getUserName());
        poolProperties.setPassword(configurationProperties.getDatabaseConfiguration().getPassword());
        poolProperties.setJmxEnabled(true);
        poolProperties.setValidationQuery("SELECT 1");
        poolProperties.setTestOnReturn(false);
        poolProperties.setValidationInterval(30000);
        poolProperties.setMaxActive(100);
        poolProperties.setInitialSize(10);
        poolProperties.setMaxWait(10000);
        poolProperties.setRemoveAbandonedTimeout(60);
        poolProperties.setMinEvictableIdleTimeMillis(30000);
        poolProperties.setMinIdle(10);
        poolProperties.setLogAbandoned(true);
        poolProperties.setRemoveAbandoned(true);
        poolProperties.setTestWhileIdle(true);
        poolProperties.setTimeBetweenEvictionRunsMillis(30000);
        poolProperties.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
                "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        DataSource dataSource = new DataSource(poolProperties);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"com.akash.github.springdatajpamysql.db.entities"});
        em.setJpaProperties(properties());
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return jpaTransactionManager;
    }

    private Properties properties() {

        Properties properties = new Properties();
        properties.setProperty("hibernate.ddl-auto", configurationProperties.getDatabaseConfiguration().getHibernate().getDdlAuto());
        properties.setProperty("hibernate.dialect", configurationProperties.getDatabaseConfiguration().getHibernate().getDialect());
        properties.setProperty("hibernate.show_sql", configurationProperties.getDatabaseConfiguration().getHibernate().getShowSql());
        return properties;
    }
}
