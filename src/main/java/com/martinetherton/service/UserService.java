package com.martinetherton.service;

import com.martinetherton.model.User;

public interface UserService  {

	User getUserWith(String bsn);

	void add(User user);

}
