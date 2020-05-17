package com.system.evoucher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.evoucher.exception.InvalidUserException;
import com.system.evoucher.model.UserEntity;
import com.system.evoucher.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public boolean isValidUser(Integer mobileNumber) {
		
		return repository.findByMobileNumber(mobileNumber)!=null;
}
	
	public UserEntity getUserDetails(int mobileNumber) throws InvalidUserException {
		UserEntity user = repository.findByMobileNumber(mobileNumber);
		if(user==null) {
			throw new InvalidUserException("Invalid user");
		}
		return repository.findByMobileNumber(mobileNumber);
	}

}
