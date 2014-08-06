package com.martinetherton.model;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class PartnerTest {

	@Test
	public void settersAndGetters() {
		
		Partner partnerShip = new Partner();
		
		User partnerUser = new User();
		User user = new User();
		partnerUser.setFirstName("partners FirstName");
		user.setFirstName("users FirstName");
		
	//	partnerShip.setPartner(partnerUser);
	//	partnerShip.setUser(user);
		
		//assertThat(partnerShip.getPartner().getFirstName(), Matchers.is("partners FirstName"));
		//assertThat(partnerShip.getUser().getFirstName(), Matchers.is("users FirstName"));
	}
	
}
