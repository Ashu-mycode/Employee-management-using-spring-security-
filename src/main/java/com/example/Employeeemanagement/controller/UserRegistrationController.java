/*
 * This class for user registration class that a new user registration
 * */


package com.example.Employeeemanagement.controller;

import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Employeeemanagement.dto.UserRegistrationDto;
//import com.example.Employeeemanagement.entity.User;
import com.example.Employeeemanagement.service.IUserService;

@EnableCaching
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	
	private IUserService iUserService;
	
	public UserRegistrationController(IUserService iUserService) {
		super();
		this.iUserService = iUserService;
	}
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	//Method handler for registration form
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	
	/*@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		iUserService.save(registrationDto);
		return "redirect:/registration?success";
	}*/
	
	
	//For successfully registration of user for security purpose
	@PostMapping
    public String registerUserAccount( @ModelAttribute("user") UserRegistrationDto registrationDto, 
                                      BindingResult result){

       /* User existing = iUserService.findByEmail(registrationDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "registration";
        }*/

        iUserService.save(registrationDto);
        return "redirect:/registration?success";
    }

}
