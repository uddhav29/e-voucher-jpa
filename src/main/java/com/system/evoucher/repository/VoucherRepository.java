package com.system.evoucher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.system.evoucher.model.VoucherEntity;

@Repository
public interface VoucherRepository 
			extends CrudRepository<VoucherEntity, Long> {

	public VoucherEntity findByCode(String code);
}

