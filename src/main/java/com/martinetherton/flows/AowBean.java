package com.martinetherton.flows;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
//import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.martinetherton.model.Partner;
import com.martinetherton.model.User;
import com.martinetherton.service.UserService;
import com.martinetherton.service.UserServiceImpl;

@Component
@SessionScoped
public class AowBean implements Serializable {

	private String name;
	private String firstName;
	private String surname;
	private Date birthDate;
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
	public AowBean(UserService userService) {
		this.userService = userService;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBsn() {
		return bsn;
	}

	public void setBsn(String bsn) {
		this.bsn = bsn;
	}
	
	public String aowDetails() {
		setUser(userService.getUserWith(bsn));
		return "aowBasicInformation";
	}

	public String sendToDms() {
		userService.add(user);
		return "dms";
	}	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		if (user.getPartner() == null) {
			user.setPartner(new Partner());
		}
		this.user = user;
	}
	
}
