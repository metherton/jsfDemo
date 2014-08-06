package com.martinetherton.persist;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.martinetherton.flows.AowBean;
import com.martinetherton.model.Partner;
import com.martinetherton.model.User;

public class UserRepositoryTest {

	private UserRepository repository;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	@Before
	public void setUp() {
		entityManagerFactory = createEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
        repository = new UserRepositoryImpl();
        repository.setEntityManager(entityManager);   		
	}
	
	@Test
	public void findUserByBsn() {
		String bsn = "123456789";
		User user = repository.getUserWith(bsn);
		assertNotNull(user);
		assertThat(user.getFirstName(), Matchers.is("Jack"));
	//	assertThat(user.getPartner().getBsn(), Matchers.is("42"));
	}

	@Test
	public void insertUser() {
		User newUser = new User();
		newUser.setBsn("2");
		newUser.setFirstName("John");
		newUser.setSurname("Smith");
		newUser.setDateOfBirth(new Date());
		Partner newPartner = new Partner();
		newPartner.setBsn("123");
	//	newPartner.setUser(newUser);
		newUser.setPartner(newPartner);
		repository.add(newUser);
	}	

	@Test
	public void findUserById() {
		User user = repository.getUserWithId(1L);
		assertNotNull(user);
		assertThat(user.getPartner().getBsn(), Matchers.is("66"));
	}		
	

	
    private EntityManagerFactory createEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(createTestDataSource());
        
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.HSQL);
        jpaVendorAdapter.setShowSql(true);
        
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        
        Map<String, String> jpaProperties = new HashMap<String, String>();
        jpaProperties.put("hibernate.format_sql", "true");
        entityManagerFactoryBean.setJpaPropertyMap(jpaProperties);
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean.getObject();
    }  	

    @After
    public void shutdownAccountRepository(){
        if(entityManager != null){
            entityManager.close();
        }
        
        if(entityManagerFactory != null){
            entityManagerFactory.close();
        }
    }
        
    
    /**
     * We are not using Spring in this unit test, so we have to setup our
     * embedded database manually.
     * 
     * @return The factory.
     */
    private DataSource createTestDataSource() {
        return new EmbeddedDatabaseBuilder()
        .setName("jsfdemo")
        .addScript("classpath:/META-INF/db/schema.sql")
        .addScript("classpath:/META-INF/db/test-data.sql")
        .build();        
    }        
    
}
