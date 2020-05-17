package com.system.evoucher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    
    @Column(name="mob_nmbr")
    private Integer mobileNumber;
    
    @Column(name="passwrd")
    private String password;
    
    @Column(name="role")
    private String role;

	public UserEntity(Long user_id, Integer mobileNumber, String password, String role) {
		super();
		this.user_id = user_id;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.role = role;
	}

	public UserEntity() {
		
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserEntity [user_id=" + user_id + ", mobileNumber=" + mobileNumber + ", password=" + password
				+ ", role=" + role + "]";
	}
    
    
    
    
}
