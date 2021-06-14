/*
 * Implementation of all method of EmployeeService interface  
 * */


package com.example.Employeeemanagement.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Employeeemanagement.entity.Employees;
import com.example.Employeeemanagement.repository.IEmployeeRepository;

@Service
public class EmployeeServiceimp implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepository iEmployeeRepository;

	
	@Override
	public List<Employees> getAllEmployees() {
		
		return iEmployeeRepository.findAll();
	}

	//Implementation of save an employee
	@Override
	public void saveEmployee(Employees employee) {
		this.iEmployeeRepository.save(employee);
		
	}

	//Implementation of get an employee by using employee id
	@Override
	public Employees getEmployeeById(long id) {
		Optional<Employees> optional = iEmployeeRepository.findById(id);
		Employees employee =null;
		if(optional.isPresent()) {
			employee=optional.get();
		}else {
			throw new RuntimeException("Employee not found::"+id);
		}
		return employee;
	}

	//Implementation of delete an employee by id
	@Override
	public void deleteEmployeeById(long id) {
		this.iEmployeeRepository.deleteById(id);
		
	}

	//Implementation of Paging and sorting method
	@Override
	public Page<Employees> findPaginated(int pageNum, int pageSize,String sortField,String sortDir) {
		
		//Sorting
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():Sort.by(sortField).descending();
		
		//Paging
		Pageable pageable = PageRequest.of(pageNum -1, pageSize,sort);
		return this.iEmployeeRepository.findAll(pageable);
	}

	/*@Override
	public void deleteEmployeeByIdAndStatus(long id, String status) {
		this.iEmployeeRepository.deleteByIdAndStatus(id,status);
		
	}*/
	
	

}
