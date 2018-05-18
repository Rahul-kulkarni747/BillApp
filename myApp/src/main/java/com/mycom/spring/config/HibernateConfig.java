package com.mycom.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

	@Bean
	public LocalSessionFactoryBean getSessionFactory(){
		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setDataSource(getDataSource());
		bean.setPackagesToScan("com.mycom.spring.*");
		bean.setHibernateProperties(hibernateProperties());
		return bean;
	}
	
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");
       // properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
        return properties;        
   }
	
	@Bean
	public DataSource getDataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://billappinstance.cthtilzlgbsk.ap-south-1.rds.amazonaws.com:3306/Rahul");
	    dataSource.setUsername("Rahul");
	    dataSource.setPassword("rahullegend");
	    return dataSource;
	}
	
	@Bean
	public HibernateTransactionManager getTransaction(){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
	
}
