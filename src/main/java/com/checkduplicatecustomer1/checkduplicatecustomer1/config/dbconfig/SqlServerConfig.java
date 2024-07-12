package com.checkduplicatecustomer1.checkduplicatecustomer1.config.dbconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

// import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "sqlServerEntityManagerFactory",
        transactionManagerRef = "sqlServerTransactionManager",
        basePackages = "com.checkduplicatecustomer1.checkduplicatecustomer1.user.repo")
public class SqlServerConfig {

    @Bean
    @ConfigurationProperties(prefix = "sqlserver.datasource")
    public DataSourceProperties sqlServerDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    public DataSource sqlServerDataSource(@Qualifier("sqlServerDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "sqlServerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sqlServerEntityManagerFactory(@Qualifier("sqlServerDataSource") DataSource sqlServerDataSource, EntityManagerFactoryBuilder builder) {

        return builder.dataSource(sqlServerDataSource)
                .packages("com.checkduplicatecustomer1.checkduplicatecustomer1.user")
                .persistenceUnit("sqlserver")
                .build();

    }

    @Bean
    public PlatformTransactionManager sqlServerTransactionManager(@Qualifier("sqlServerEntityManagerFactory")
    LocalContainerEntityManagerFactoryBean factory) {
        return new JpaTransactionManager(factory.getObject());
    }

}