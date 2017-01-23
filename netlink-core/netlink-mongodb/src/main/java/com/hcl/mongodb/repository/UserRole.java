package com.hcl.mongodb.repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserRole")
public class UserRole {

	private Long userid;
	
	private  Long userroleid;
	private String role;
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getUserroleid() {
		return userroleid;
	}
	public void setUserroleid(Long userroleid) {
		this.userroleid = userroleid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserRole [userid=" + userid + ", userroleid=" + userroleid + ", role=" + role + "]";
	}	
	
}
