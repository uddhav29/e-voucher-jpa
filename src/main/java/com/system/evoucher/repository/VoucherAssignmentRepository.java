package com.system.evoucher.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.system.evoucher.model.VoucherAssignmentEntity;

@Repository
public interface VoucherAssignmentRepository 
			extends CrudRepository<VoucherAssignmentEntity, Long> {

	public List<VoucherAssignmentEntity> findByMobileNumber(int mobileNumber);
	
	public List<VoucherAssignmentEntity> findByVoucherId(Long voucherId);
}

