/*
 * Repository of User which inherited by JpaRepo it is Contain many method which is built-in java 
 * */

package com.example.Employeeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Employeeemanagement.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
	
	User findByEmail(String email);

}
