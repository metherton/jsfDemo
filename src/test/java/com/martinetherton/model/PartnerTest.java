package com.martinetherton.model;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class PartnerTest {

	@Test
	public void settersAndGetters() {
		
		Partner partner = new Partner();
		partner.setBsn("123");
		
		Assert.assertThat(partner.getBsn(), Matchers.is("123"));
	}
	
}
