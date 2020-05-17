package com.system.evoucher.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.evoucher.model.VoucherAssignmentEntity;
import com.system.evoucher.model.VoucherEntity;
import com.system.evoucher.repository.VoucherAssignmentRepository;
import com.system.evoucher.repository.VoucherRepository;

@Service
public class VoucherService {
	
	@Autowired
	VoucherRepository repository;
	
	@Autowired
	VoucherAssignmentRepository voucherAssignmentRepository;
	
	public List<VoucherEntity> getAllValidVouchers()
	{
		List<VoucherEntity> vouchers = (List<VoucherEntity>) repository.findAll();
		Date currentDate = new Date();
		
		
		List<VoucherEntity> validVouchers = vouchers.stream().filter(voucher-> voucher.getStartDate().before(currentDate))
						.filter(voucher->voucher.getEndDate().after(currentDate))
					   .filter(voucher->!voucher.getRedeemFlag())
					   .collect(Collectors.toList()); 
		
		
		if(validVouchers.size() > 0) {
			return validVouchers;
		} else {
			return new ArrayList<VoucherEntity>();
		}
	}
	


	public List<VoucherEntity> getAllValidVouchersForConsumer(int mobileNumber){
		List<VoucherAssignmentEntity> voucherAssignmentEntities = voucherAssignmentRepository.findByMobileNumber(mobileNumber);
		List<VoucherEntity> validVouchers = new ArrayList<VoucherEntity>();
		for(VoucherAssignmentEntity voucherAssignmentEntity: voucherAssignmentEntities) {
			validVouchers.add(repository.findById(voucherAssignmentEntity.getVoucherId()).get());
		}
		return validVouchers;
	}
	
	public void redeemValidVouchers(String voucherCode) {
		List<VoucherAssignmentEntity> voucherAssignmentEntities = voucherAssignmentRepository.findByVoucherId(getVoucherIdFor(voucherCode));
		List<VoucherEntity> validVouchers = new ArrayList<VoucherEntity>();
		for(VoucherAssignmentEntity voucherAssignmentEntity: voucherAssignmentEntities) {
			VoucherEntity voucherEntity = repository.findById(voucherAssignmentEntity.getVoucherId()).get();
			voucherEntity.setRedeemFlag(true);
			validVouchers.add(voucherEntity);
		}
		repository.saveAll(validVouchers);
	}
	
	public Long getVoucherIdFor(String voucherCode) {
		return repository.findByCode(voucherCode).getId();
	}
	
	public void assignVouchers(List<VoucherAssignmentEntity> voucherAssignmentEntities) {
			voucherAssignmentRepository.saveAll(voucherAssignmentEntities);
	}

}
