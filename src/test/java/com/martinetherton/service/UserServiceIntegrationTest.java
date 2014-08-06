package com.martinetherton.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.martinetherton.model.Partner;
import com.martinetherton.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/springconfig/app-services-config.xml")
@ActiveProfiles("dev")
public class UserServiceIntegrationTest {

    @Autowired
    UserService userService;
    
    @Test
    public void getUser() {
        User user = userService.getUserWith("123456789");
		assertThat(user.getFirstName(), is("Jack"));
	//	assertThat(user.getPartner().getBsn(), Matchers.is("42"));
    }	
    
    @Test
    public void addUser() {
    	//User already = userService.getUserWith(bsn)
		User newUser = new User();
		newUser.setBsn("2");
		newUser.setFirstName("John");
		newUser.setSurname("Smith");
		newUser.setDateOfBirth(new Date());
		Partner newPartner = new Partner();
		newPartner.setBsn("98");
		newUser.setPartner(newPartner);
		userService.add(newUser);    
		User insertedUser = userService.getUserWith("2");
    }
	
}
