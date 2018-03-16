package com.app.data;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfiguration {
	@Value("${db.driver}")
    private String DRIVER;
 
    @Value("${db.password}")
    private String PASSWORD;
 
    @Value("${db.url}")
    private String URL;
 
    @Value("${db.username}")
    private String USERNAME;
    
    @Value("${hibernate.dialect}")
    private String DIALECT;
 
    @Value("${hibernate.show_sql}")
    private String SHOW_SQL;
 
    @Value("${hibernate.hbm2ddl.auto}")
    private String HBM2DDL_AUTO;

    @Value("${hibernate.use_sql_comments}")
    private String USE_SQL_COMMENTS;
    
    @Value("${hibernate.format_sql}")
    private String FORMAT_SQL;
    
    @Value("${hibernate.generate_statistics}")
    private String GENERATE_STATISTICS;
    
    @Value("${javax.persistence.validation.mode}")
    private String VALIDATION_MODE;
    
    @Value("${org.hibernate.envers.store_data_at_delete}")
    private String STORE_DATA_AT_DELETE;
    
    @Value("${org.hibernate.envers.global_with_modified_flag}")
    private String MODIFIED_FLAG;


	@Bean
	public DataSource readDatasource() {
		DriverManagerDataSource dmdatasource=new DriverManagerDataSource();
		dmdatasource.setDriverClassName(DRIVER);
		dmdatasource.setUrl(URL);
		dmdatasource.setUsername(USERNAME);
		dmdatasource.setPassword(PASSWORD);
		return dmdatasource;
	}

	@Bean
	protected Properties hibenateConfig() {
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.dialect", DIALECT);
		hibernateProperties.setProperty("hibernate.show_sql", SHOW_SQL);
		hibernateProperties.setProperty("hibernate.use_sql_comments", USE_SQL_COMMENTS);
		hibernateProperties.setProperty("hibernate.format_sql", FORMAT_SQL);
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
		hibernateProperties.setProperty("hibernate.generate_statistics", GENERATE_STATISTICS);
		hibernateProperties.setProperty("javax.persistence.validation.mode", VALIDATION_MODE);
		hibernateProperties.setProperty("org.hibernate.envers.store_data_at_delete", STORE_DATA_AT_DELETE);
		hibernateProperties.setProperty("org.hibernate.envers.global_with_modified_flag", MODIFIED_FLAG);
		hibernateProperties.setProperty("hibernate.current_session_context_class", SpringSessionContext.class.getName());

		return hibernateProperties;
	}

	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
		return new HibernateJpaSessionFactoryBean();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		
		entityManagerFactoryBean.setDataSource(readDatasource());
		entityManagerFactoryBean.setJpaProperties(hibenateConfig());
		
		HibernateJpaVendorAdapter jpaVendorAdapter=new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
		
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);;
		entityManagerFactoryBean.setPackagesToScan("com.app.data.model");
		return entityManagerFactoryBean;
		
	}
}