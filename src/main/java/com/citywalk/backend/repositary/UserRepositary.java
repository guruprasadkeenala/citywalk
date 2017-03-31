package com.citywalk.backend.repositary;

import com.citywalk.backend.exception.CitywalkException;
import com.citywalk.backend.modal.User;

public interface UserRepositary {

	public void save(User user) throws CitywalkException;
	
	public User getUser(User user) throws CitywalkException;
	
}
