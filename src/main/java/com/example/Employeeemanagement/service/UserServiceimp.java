/*
 * Implementation of all method of UserService interface  
 * */

package com.example.Employeeemanagement.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Employeeemanagement.dto.UserRegistrationDto;
import com.example.Employeeemanagement.entity.Role;
import com.example.Employeeemanagement.entity.User;
import com.example.Employeeemanagement.repository.IUserRepository;

@Service
public class UserServiceimp implements IUserService {
	
	private IUserRepository iUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceimp(IUserRepository iUserRepository) {
		super();
		this.iUserRepository = iUserRepository;
	}
	
	//Implementation of save user info for registration
	@Override
	public User save(UserRegistrationDto registrationDto) {
		
		User user = new User();
		user.setFirstName(registrationDto.getFirstName());
		user.setLastName(registrationDto.getLastName());
		user.setEmail(registrationDto.getEmail());
		user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		user.setRoles(Arrays.asList(new Role("ROLE_USER")));
		
		/*User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));*/
		
		return iUserRepository.save(user);
	}
	

    //Implementation of User that is valid user email or not Mapped correct Username(Email) and password provide by User 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = iUserRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	//Implementation of find email of User
	@Override
	public User findByEmail(String email) {
		
		return iUserRepository.findByEmail(email);
	}

	

	

	
	

}
