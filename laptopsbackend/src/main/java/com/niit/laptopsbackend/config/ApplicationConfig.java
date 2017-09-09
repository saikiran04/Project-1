package com.niit.laptopsbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.laptopsbackend.dao.ProductDAO;
import com.niit.laptopsbackend.dao.ProductDAOImpl;
import com.niit.laptopsbackend.model.Product;
import com.niit.laptopsbackend.model.User;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement

public class ApplicationConfig {
	@Bean(name="DataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/sai");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		System.out.println("data source");
		return dataSource;
		
	}
	
	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.current_session_context_class","thread");
		System.out.println("hibernate");
		return properties;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Product.class);
		sessionBuilder.addAnnotatedClasses(User.class);
		System.out.println("session factory");
		return sessionBuilder.buildSessionFactory();
	}
	
	/*@Autowired
	@Bean(name="productDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory)
	{
		return new ProductDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="product")
	public Product getProduct()
	{
		return new Product();
	}*/

}
