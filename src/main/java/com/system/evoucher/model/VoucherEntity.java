package com.system.evoucher.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="vouchers")
public class VoucherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="voucher_id")
    private Long id;
    
    @Column(name="voucher_code")
    private String code;

    @Column(name="redeem_flg")
    private Boolean redeemFlag;

    @Column(name="amount")
    private Double amount;
    
    @Column(name="start_dt")
    private Date startDate;
    
    @Column(name="end_dt")
    private Date endDate;

    
	public VoucherEntity() {
		
	}

	public VoucherEntity(Long id, String code, Boolean redeemFlag, Double amount, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.code = code;
		this.redeemFlag = redeemFlag;
		this.amount = amount;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getRedeemFlag() {
		return redeemFlag;
	}

	public void setRedeemFlag(Boolean redeemFlag) {
		this.redeemFlag = redeemFlag;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "VoucherEntity [id=" + id + ", code=" + code + ", redeemFlag=" + redeemFlag + ", amount=" + amount
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
    
	
    
}
