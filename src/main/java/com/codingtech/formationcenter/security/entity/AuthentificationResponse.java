package com.codingtech.formationcenter.security.entity;

import org.springframework.security.core.userdetails.UserDetails;

public class AuthentificationResponse {
	private final String jwt;
	private final UserDetails userDetails;

	public String getJwt() {
		return jwt;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public AuthentificationResponse(String jwt , UserDetails userDetails1) {
		this.jwt = jwt;
		this.userDetails = userDetails1;
	}
	
	
	
	
	
	

}
