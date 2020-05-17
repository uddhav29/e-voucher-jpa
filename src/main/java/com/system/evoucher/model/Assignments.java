package com.system.evoucher.model;

import java.util.ArrayList;
import java.util.List;

public class Assignments {

	List<Long> vouchersIds = new ArrayList<Long>();
	
	int mobileNumber;
	
	
	public List<Long> getVouchersIds() {
		return vouchersIds;
	}
	public void setVouchersIds(List<Long> vouchersIds) {
		this.vouchersIds = vouchersIds;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "Assignments [vouchersIds=" + vouchersIds + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
