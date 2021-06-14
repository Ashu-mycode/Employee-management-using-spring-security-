/*
 * This controller only purpose of deal Employees attributes
 * */

package com.example.Employeeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Employeeemanagement.entity.Employees;
import com.example.Employeeemanagement.service.IEmployeeService;

@EnableCaching
@Controller
public class EmployeesController {
	
	@Autowired
	private IEmployeeService iEmployeeService;
	
	//Method handler for showing home page/List of all employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		//after showing paging system
		return findPaginated(1,"firstname","asc",model);
		
		//showing list of all employee
		//model.addAttribute("listEmployees",iEmployeeService.getAllEmployees());
		//return "index";
	}
	
	//Method handler for show new employee adding form 
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		
		//create model attribute to bind form data
		Employees employee = new Employees();
		model.addAttribute("employee",employee);
		return "new_employee";
		
	}
	
	//Method handler for save new employee
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employees employee) {
		
		//save employee to database
		iEmployeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	//Method handler for update data of employee/changes data of employee
	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable (value="id")long id,Model model) {
		
		//get employee from the service
		Employees employee = iEmployeeService.getEmployeeById(id);
		
		//set employee attribute to form
		model.addAttribute("employee",employee);
		return "update_employee";
	}
	
	//Method handler for delete an employee from database
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value="id")long id) {
		
		//call delete employee method
		this.iEmployeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	/*@GetMapping("/deleteEmployee/{id}{status}")
	public String deleteEmployees(@PathVariable (value="id")long id,
			                       @PathVariable (value="status")String status) {
		
		//call delete employee method
		this.iEmployeeService.deleteEmployeeByIdAndStatus(id,status);
		return "redirect:/";
	}*/
	
	
	
	//Method handler for Pagging system show in for naxt page and sorting technique also like Asc/Dsc 
	@GetMapping("/page/{pageNum}")
	public String findPaginated(@PathVariable (value="pageNum")int pageNum, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 6;
		
		Page<Employees> page = iEmployeeService.findPaginated(pageNum, pageSize,sortField,sortDir);
		List<Employees> listEmployees = page.getContent();
		
		// Paging Info Pass to Thymeleaf
		model.addAttribute("currentPage",pageNum);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("totalItems",page.getTotalElements());
		
		//Sorting info Pass to Thymeleaf
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDir",sortDir);
		model.addAttribute("reverseSortDir",sortDir.equals("asc")? "desc" : "asc");
		
		model.addAttribute("listEmployees",listEmployees);
		return "index";
		
	}

}
