package com.martinetherton.flows;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.martinetherton.model.User;
import com.martinetherton.service.UserService;


public class AowBeanTest {

	@Test
	public void getUserDetails() {
		UserService mockUserService = Mockito.mock(UserService.class);
		AowBean aowBean = new AowBean(mockUserService );
		aowBean.setBsn("123456789");
		
		User user = new User();
		user.setBsn("123456789");
		user.setFirstName("userFirstName");
		when(mockUserService.getUserWith("123456789")).thenReturn(user);
		
		String viewName = aowBean.aowDetails();
		assertThat(viewName, is("aowBasicInformation"));
		Mockito.verify(mockUserService).getUserWith("123456789");
	}
	
}
