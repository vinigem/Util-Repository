package com.igate.employee.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.igate.employee.exception.TechnicalException;
import com.igate.employee.forms.Employee;
import com.igate.employee.forms.Login;
import com.igate.employee.service.EmployeeService;

@Controller
@RequestMapping("/*.htm")
public class LinkControllerImpl implements LinkController{
	@Autowired(required=true)
	private EmployeeService employeeService;
	
	@RequestMapping("/Home.htm")
	public String showLogin(final Model model){
		model.addAttribute(new Login());
		return "Home";
	}
	
	@RequestMapping("/viewEmployees.htm")
	public ModelAndView showEmployees(){
		ModelAndView mav=new ModelAndView();
	    try{
	    List<Employee> empList=employeeService.getAllEmployees();
	    mav.addObject("empList",empList);
	    mav.addObject("listSize", empList.size());
	    mav.addObject("index", 0);
	    mav.setViewName("showEmployees");
		    }catch(TechnicalException te){
	    	mav.addObject("Message","Some Technical Problem Occurred!!");
	 	    mav.setViewName("showEmployees");
	        }
	    return mav;
	}
	
	@RequestMapping("/searchEmployee.htm")
	public String showSearchEmployee(final Model model){
		model.addAttribute(new Employee());
		return "showSearchEmployee";
	}
	
	
	@RequestMapping("/viewEmployee.htm")
	public String showViewEmployee(final Model model){
		model.addAttribute(new Employee());
		return "showViewEmployee";
	}
	
	@RequestMapping("/addEmployee.htm")
	public String showAddEmployee(final Model model){
		model.addAttribute(new Employee());
		return "showAddEmployee";
	}
	
	@RequestMapping("/updateEmployee.htm")
	public String showUpdateEmployee(final Model model){
		model.addAttribute(new Employee());
		return "showUpdateEmployee";
	}
	
	
	@RequestMapping("/deleteEmployee.htm")
	public ModelAndView showDeleteEmployee(final HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		mav.addObject("Message", request.getParameter("Message"));
		try{
	    List<Employee> empList=employeeService.getAllEmployees();
	    mav.addObject("empList",empList);
	    mav.setViewName("showDeleteEmployee");
		    }catch(TechnicalException te){
	    	mav.addObject("Message","Some Technical Problem Occurred!!");
	 	    mav.setViewName("showDeleteEmployee");
	        }
	    return mav;
	}
	
	
}
