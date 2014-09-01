package com.martinetherton.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import com.martinetherton.flows.AowBean;
import com.martinetherton.model.User;
import com.martinetherton.persist.UserRepository;

public class UserServiceImplTest {

	private UserService userService;
	private UserRepository mockUserRepository;
	
	@Before
	public void setUp() {
		mockUserRepository = Mockito.mock(UserRepository.class);
		userService = new UserServiceImpl(mockUserRepository);	
	}
	
	
	@Test
	public void getUserShouldBeInvokedOnRepository() {
		User expectedUser = new User();
		expectedUser.setBsn("123456789");
		expectedUser.setFirstName("userFirstName");
		when(mockUserRepository.getUserWith("123456789")).thenReturn(expectedUser);
		
		User actualUser = userService.getUserWith("123456789");
		
		assertThat(actualUser.getBsn(), is(expectedUser.getBsn()));
		verify(mockUserRepository).getUserWith("123456789");		
		
	}
	
	
}
