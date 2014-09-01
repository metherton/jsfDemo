package com.martinetherton.flows;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.martinetherton.model.User;
import com.martinetherton.service.UserService;


public class AowBeanTest {

	private AowBean aowBean;
	private UserService mockUserService;
	
	@Before
	public void setUp() {
		mockUserService = Mockito.mock(UserService.class);
		aowBean = new AowBean(mockUserService );	
		aowBean.setBsn("123456789");
	}

	@Test
	public void getUserDetails() {
		User expectedUser = new User();
		expectedUser.setBsn("123456789");
		expectedUser.setFirstName("userFirstName");
		when(mockUserService.getUserWith("123456789")).thenReturn(expectedUser);
		
		String viewName = aowBean.aowDetails();
		
		assertThat(viewName, is("aowBasicInformation"));
		verify(mockUserService).getUserWith("123456789");
	}
	
}
