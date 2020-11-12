package com.example.suspectservice.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ConfigurationProperties
public class YTConfig {

    @Value("${heroku.db.host}")
    private String host;

    @Value("${heroku.db.port}")
    private String port;

    @Value("${heroku.db.user}")
    private String username;

    @Value("${heroku.db.password}")
    private String password;

    @Value("${heroku.dbname}")
    private String dbname;
    

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public DataSource dataSource() {
      
        String dbUrl = "jdbc:postgresql://" + host + ':' + port +"/"+ dbname + "?sslmode=require";

        System.out.println("DB url ::: " +dbUrl);

        //BasicDataSource basicDataSource = new BasicDataSource();
        DriverManagerDataSource basicDataSource = new DriverManagerDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
       LocalContainerEntityManagerFactoryBean em 
         = new LocalContainerEntityManagerFactoryBean();
       em.setDataSource(dataSource());
       em.setPackagesToScan(new String[] { "com.example.suspectservice" });
  
       JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
       em.setJpaVendorAdapter(vendorAdapter);
       em.setJpaProperties(additionalProperties());
  
       return em;
    }
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
     
        return transactionManager;
    }
     
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
     
    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
           
        return properties;
    }
}
//postgres://kfbzfohzhnpmor:0419cb0f26255817aefe67da45b41d3619ba8d94d258359e2b77d86af5acf7c5@ec2-54-156-121-142.compute-1.amazonaws.com:5432/d1q1tktmnp8l6g