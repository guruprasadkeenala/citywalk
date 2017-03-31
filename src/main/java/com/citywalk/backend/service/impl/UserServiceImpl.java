package com.citywalk.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citywalk.backend.exception.CitywalkException;
import com.citywalk.backend.modal.User;
import com.citywalk.backend.repositary.UserRepositary;
import com.citywalk.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositary userRepositary;
	
	@Override
	public void save(final User user) throws CitywalkException{
		try{
			userRepositary.save(user);
		} catch(CitywalkException ce){
			ce.printStackTrace();
		}
	}

	@Override
	public User getUser(User user) throws CitywalkException {
		try{
			user = userRepositary.getUser(user);
			return user;
		} catch(CitywalkException ce){
			ce.printStackTrace();
		}
		return null;
	}

}
