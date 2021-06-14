/*
 * UserService definition of all method not implementation
 * */

package com.example.Employeeemanagement.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.Employeeemanagement.dto.UserRegistrationDto;
import com.example.Employeeemanagement.entity.User;

public interface IUserService extends UserDetailsService {
	
	User save(UserRegistrationDto registrationDto);
	User findByEmail(String email);

}
