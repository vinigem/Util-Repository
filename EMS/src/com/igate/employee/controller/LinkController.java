package com.igate.employee.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface LinkController {
	
	public String showLogin(final Model model);
	
	public ModelAndView showEmployees();
		
	public String showSearchEmployee(final Model model);
		
	public String showViewEmployee(final Model model);
		
	public String showAddEmployee(final Model model);
		
	public String showUpdateEmployee(final Model model);
		
	public ModelAndView showDeleteEmployee(final HttpServletRequest request);

}
