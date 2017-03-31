package com.citywalk.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Configuration
@EnableTransactionManagement
@ComponentScan("com.citywalk.backend")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.citywalk.backend.repository")
public class CitywalkDBConfigutaion {
    @Value("${spring.datasource.driver-class-name}")
    private String DATABASE_DRIVER;
 
    @Value("${spring.datasource.url}")
    private String DATABASE_URL;
 
    @Value("${spring.datasource.username}")
    private String DATABASE_USERNAME;
    
    @Value("${spring.datasource.password}")
    private String DATABASE_PASSWORD;
 
    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String HIBERNATE_DIALECT;
 
    @Value("${spring.jpa.show-sql}")
    private String HIBERNATE_SHOW_SQL;
 
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String HBM2DDL_AUTO;
 
    @Value("${entitymanager.packages.to.scan}")
    private String PACKAGES_TO_SCAN;
    
    @Bean
    public DataSource getDataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(DATABASE_DRIVER);
      dataSource.setUrl(DATABASE_URL);
      dataSource.setUsername(DATABASE_USERNAME);
      dataSource.setPassword(DATABASE_PASSWORD);
      return dataSource;
    }

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean jpaEntityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		jpaEntityManagerFactory.setDataSource(getDataSource());
		jpaEntityManagerFactory.setPackagesToScan(PACKAGES_TO_SCAN);
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		jpaEntityManagerFactory.setJpaVendorAdapter(vendorAdapter);
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("dialect", HIBERNATE_DIALECT);
		hibernateProperties.put("show_sql", HIBERNATE_SHOW_SQL);
		hibernateProperties.put("hbm2ddl.auto", HBM2DDL_AUTO);
		jpaEntityManagerFactory.setJpaProperties(hibernateProperties);
		return jpaEntityManagerFactory;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return jpaTransactionManager;
	}
	
    /*@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
 
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", DIALECT);
        hibernateProperties.put("hibernate.show_sql", SHOW_SQL);
        hibernateProperties.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }
 
    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }*/
}
