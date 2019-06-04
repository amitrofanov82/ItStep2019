package com.epam.mentoring.spring.core.service.impl;

import org.springframework.stereotype.Component;

import com.epam.mentoring.spring.core.model.User;

@Component
public class AuthService {
	
	public User getUserBy(String name, int pswHAshCode) {
		//call db, some DAO reference. 
		//on DAO level retutn null or 
		//throw Exception if no such user with such password
		return null;
	}
	
}
