/*
 * EmployeeService definition of all method not implementation
 * */

package com.example.Employeeemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.Employeeemanagement.entity.Employees;

public interface IEmployeeService {
	public List<Employees> getAllEmployees();
	void saveEmployee(Employees employee);
	Employees getEmployeeById(long id);
	void deleteEmployeeById(long id);
	Page<Employees> findPaginated(int pageNum,int pageSize,String sortField,String sortDir);
	
	

}
