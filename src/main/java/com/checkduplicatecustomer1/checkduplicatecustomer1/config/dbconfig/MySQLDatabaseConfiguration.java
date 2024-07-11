package com.checkduplicatecustomer1.checkduplicatecustomer1.config.dbconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "mySqlEntityManager",
        basePackages = "com.checkduplicatecustomer1.checkduplicatecustomer1.repository",
        transactionManagerRef = "mySqlTransactionManager"
)
public class MySQLDatabaseConfiguration {
    @Primary
    @Bean("mysqlDb")
    @ConfigurationProperties(prefix = "mysql.datasource")
    public DataSource mySqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("mySqlEntityManager")
    public LocalContainerEntityManagerFactoryBean mySqlEntityManager(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
        jpaProperties.put("hibernate.ddl-auto", "update");
        jpaProperties.put("spring.jpa.generate-ddl", "true");
        jpaProperties.put("hibernate.show_sql", "true");

        return entityManagerFactoryBuilder
                .dataSource(mySqlDataSource())
                .packages("com.checkduplicatecustomer1.checkduplicatecustomer1.entity")
                .persistenceUnit("tblNSCRegistration")
                .properties(jpaProperties)
                .build();
    }

    @Primary
    @Bean("mySqlTransactionManager")
    public PlatformTransactionManager mySqlTransactionManager(
            @Qualifier("mySqlEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }
}