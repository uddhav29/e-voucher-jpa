package com.system.evoucher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.system.evoucher.model.UserEntity;

@Repository
public interface UserRepository 
			extends CrudRepository<UserEntity, Long> {

	public UserEntity findByMobileNumber(Integer mobileNumber); 
}

