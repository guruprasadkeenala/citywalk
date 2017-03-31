package com.citywalk.backend.service;

import com.citywalk.backend.exception.CitywalkException;
import com.citywalk.backend.modal.User;

public interface UserService {
	
	public void save(final User user) throws CitywalkException;
	
	public User getUser(final User user) throws CitywalkException;
	
}
