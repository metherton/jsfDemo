package com.martinetherton.model;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {

	@Test
	public void settersAndGetters() {
		User user = new User();
		Address address = new Address();
		address.setCity("Zwolle");

		
		
		user.setAddress(address);
		
		assertThat(user.getAddress().getCity(), Matchers.is("Zwolle"));
	}
	
}
