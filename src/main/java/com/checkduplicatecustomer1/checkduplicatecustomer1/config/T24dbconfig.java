package com.checkduplicatecustomer1.checkduplicatecustomer1.config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        entityManagerFactoryRef = "t24EntityManager",
        basePackages = "com.checkduplicatecustomer1.checkduplicatecustomer1.user",
        transactionManagerRef = "t24TransactionManager"
)
public class T24dbconfig {
    /****
     * DataSource Configuration
     ****/
    @Bean("t24Db")
    @ConfigurationProperties(prefix = "t2rcustomer.datasource")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }

    /****
     * Entity Manager Configuration
     ****/
    @Bean("t24EntityManager")
    public LocalContainerEntityManagerFactoryBean t24EntityManager(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder){
        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
        jpaProperties.put("hibernate.ddl-auto", "update");
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("datasource.url", "jdbc:sqlserver://10.1.12.69;databaseName=t24customer;encrypt=false;trustServerCertificate=false;");
        return entityManagerFactoryBuilder
                .dataSource(postgresDataSource())
                .packages("com.checkduplicatecustomer1.checkduplicatecustomer1.user")
                .persistenceUnit("_user")
                .properties(jpaProperties)
                .build();
    }

    /****
     * Transaction Manager Configuration
     ****/
    @Bean("t24TransactionManager")
    public PlatformTransactionManager t24TransactionManager(@Qualifier("t24EntityManager")
                                                              LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }


}
