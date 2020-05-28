package com.fsd.emart.user.model;

import com.fsd.emart.user.common.RoleType;

public class User {
	private String username;
	private String password;
	private RoleType role;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RoleType getRole() {
		return role;
	}
	public void setRole(RoleType role) {
		this.role = role;
	}
	 
}
