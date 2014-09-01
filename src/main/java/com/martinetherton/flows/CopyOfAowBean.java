package com.martinetherton.flows;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
//import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.martinetherton.model.Address;
import com.martinetherton.model.Partner;
import com.martinetherton.model.User;
import com.martinetherton.service.UserService;
import com.martinetherton.service.UserServiceImpl;

@Component
@SessionScoped
public class CopyOfAowBean implements Serializable {

	private String bsn;	
	private User user;
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public CopyOfAowBean(UserService userService) {
		this.userService = userService;
	}
	
	public String getBsn() {
		return bsn;
	}

	public void setBsn(String bsn) {
		this.bsn = bsn;
	}
	
	public String aowDetails() {
		this.user = userService.getUserWith(bsn);
		return "aowBasicInformation";
	}
	
	public String sendToDms() {
		userService.add(user);
		return "dms";
	}	
	
	public User getUser() {
		return user;
	}

}
