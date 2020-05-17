package com.system.evoucher.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.evoucher.exception.InvalidAssignmentException;
import com.system.evoucher.exception.InvalidUserException;
import com.system.evoucher.model.Assignments;
import com.system.evoucher.model.UserEntity;
import com.system.evoucher.model.VoucherAssignmentEntity;
import com.system.evoucher.model.VoucherEntity;
import com.system.evoucher.service.UserService;
import com.system.evoucher.service.VoucherService;

@Controller
@RequestMapping("/")
public class EVoucherMvcController 
{
	
	@Autowired
	VoucherService voucherService;
	
	@Autowired
	UserService userService;

	
	@RequestMapping(path = {"/admin"})
	public String getAllValidVouchers(Model model) 
	{
		List<VoucherEntity> list = voucherService.getAllValidVouchers();

		model.addAttribute("vouchers", list);
		model.addAttribute("assigns",new Assignments());
		return "admin_view";
	}

	
	@RequestMapping(path = {"/login"},method = RequestMethod.POST)
	public String checkValidUser(Model model, UserEntity user) throws InvalidUserException 
	{
	
			UserEntity validUser = userService.getUserDetails(user.getMobileNumber());
			
			if(validUser.getRole().equals("consumer")) {
				model.addAttribute("vouchers", voucherService.getAllValidVouchersForConsumer(user.getMobileNumber()));
				return "customer_dashboard_view";
			}
			if(validUser.getRole().equals("admin")) {
				return "redirect:/admin";
			}
			if(validUser.getRole().equals("merchant")) {
				model.addAttribute("voucher", new VoucherEntity());
				return "merchant_view";
			}
			
		
		return "no_access";
	}
	
	@RequestMapping(path = {"/login"})
	public String checkValidUser(Model model) 
	{
		
		model.addAttribute("user",new UserEntity());
		return "login_view";
	}

	
	
	@RequestMapping(path = {"/redeem"})
	public String redeemValidVouchers(Model model, VoucherEntity voucher) 
	{
		voucherService.redeemValidVouchers(voucher.getCode());
		
		return  "redirect:/login";
	}
	


	@RequestMapping(path = "/assignVouchers", method = RequestMethod.POST)
	public String assignVouchers(Assignments assigns) throws InvalidAssignmentException 
	{
		if(assigns.getVouchersIds().isEmpty()||assigns.getMobileNumber()==0) {
			throw new InvalidAssignmentException("Incorrect assignment");
		}
		voucherService.assignVouchers(mapVoucherAssignmentEntity(assigns.getVouchersIds(), assigns.getMobileNumber()));
		
		return "redirect:/login";
	}
	

	private List<VoucherAssignmentEntity> mapVoucherAssignmentEntity(List<Long> vouchers, int mobileNumber) {
		
	List<VoucherAssignmentEntity> voucherAssignmentEntities = new ArrayList<VoucherAssignmentEntity>();
	for (Long voucher : vouchers) {
		voucherAssignmentEntities.add(new VoucherAssignmentEntity(voucher,mobileNumber));
	}
		return voucherAssignmentEntities;
	}
}
