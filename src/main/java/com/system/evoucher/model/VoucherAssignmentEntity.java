package com.system.evoucher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="voucher_asgnmnt")
public class VoucherAssignmentEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="voucher_asg_id")
    private Long id;
	
	@Column(name="voucher_id")
    private Long voucherId;

    @Column(name="mob_nmbr ")
    private int mobileNumber;
    
    

	public VoucherAssignmentEntity() {
	
	}

	public VoucherAssignmentEntity(Long voucherId, int mobileNumber) {
		this.voucherId = voucherId;
		this.mobileNumber = mobileNumber;
	}

	public Long getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(Long voucherId) {
		this.voucherId = voucherId;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "VoucherAssignmentEntity [voucherId=" + voucherId + ", mobileNumber=" + mobileNumber + "]";
	}

	
    
    
}

