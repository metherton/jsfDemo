package com.martinetherton.service;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.model.User;
import com.martinetherton.persist.UserRepository;

@Service
public class UserServiceImpl implements UserService, Serializable {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@Override
	@Transactional(readOnly=true)
	public User getUserWith(String bsn) {
		return userRepository.getUserWith(bsn);
	}

	@Override
	@Transactional
	public void add(User user) {
		userRepository.add(user);
	}

}
