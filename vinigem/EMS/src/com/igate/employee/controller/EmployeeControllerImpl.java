package com.igate.employee.controller;



import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.igate.employee.exception.InvalidLoginException;
import com.igate.employee.exception.TechnicalException;
import com.igate.employee.forms.Employee;
import com.igate.employee.forms.Login;
import com.igate.employee.service.EmployeeService;


@Controller
@RequestMapping("/*.do")
public class EmployeeControllerImpl implements EmployeeController{
	@Autowired(required=true)
	private EmployeeService employeeService;
	
	
	
	
	@RequestMapping(value="/addEmp.do",method=RequestMethod.POST)
	public ModelAndView addEmployee(@Valid final Employee employee,final BindingResult result){
		ModelAndView mav=new ModelAndView();
		
		if(result.hasErrors()){
			mav.setViewName("showAddEmployee");
		}else{
		try{
		if(employeeService.addEmployee(employee)){
			mav.addObject("Message", "Employee Successfully Added!!");
			mav.setViewName("showAddEmployee");
		}else{
			mav.addObject("Message", "Employee Not Added!!");
			mav.setViewName("showAddEmployee");
		}}catch(TechnicalException te){
	    	mav.addObject("Message","Some Technical Problem Occurred!!");
	 	     mav.setViewName("showAddEmployee");
	    }
		}
		return mav;
	}
	
	
	
	@RequestMapping("/getEmployee.do")
	public ModelAndView getEmployee(final Employee employee){
		ModelAndView mav=new ModelAndView();
	   try{
	        Employee emp=employeeService.getEmployee(employee.getEid());
	    if(emp!=null){
	       employee.setEid(emp.getEid());
	       employee.setfName(emp.getfName());
	       employee.setlName(emp.getlName());
	       employee.setDeptNo(emp.getDeptNo());
	       employee.setSalary(emp.getSalary());
	        mav.setViewName("showViewEmployee");
	    }else{
	    	 mav.addObject("Message","Employee Not Found!!");
	 	    mav.setViewName("showViewEmployee");
	    }}catch(TechnicalException te){
	    	mav.addObject("Message","Some Technical Problem Occurred!!");
	 	    mav.setViewName("showViewEmployee");
	    }
	    
		return mav;
	}
	
	
	@RequestMapping("/searchEmp.do")
	public ModelAndView searchEmployee(final Employee employee){
		ModelAndView mav=new ModelAndView();
	   try{
	    List<Employee> empList=employeeService.searchEmployee(employee.getEid());
	    if(empList!=null && !empList.isEmpty()){
	        mav.addObject("empList",empList);
	    	mav.setViewName("showSearchEmployee");
	    }else{
	    	 mav.addObject("Message","No Employee Found!!");
	 	     mav.setViewName("showSearchEmployee");
	    }}catch(TechnicalException te){
	    	mav.addObject("Message","Some Technical Problem Occurred!!");
	 	     mav.setViewName("showSearchEmployee");
	    }
	    
		return mav;
	}
	

	
	@RequestMapping("/getEmp.do")
	public ModelAndView getEmp(final Employee employee){
		ModelAndView mav=new ModelAndView();
		try{
	    Employee emp=employeeService.getEmployee(employee.getEid());
	    if(emp!=null){
	       employee.setEid(emp.getEid());
	       employee.setfName(emp.getfName());
	       employee.setlName(emp.getlName());
	       employee.setDeptNo(emp.getDeptNo());
	       employee.setSalary(emp.getSalary());
	        mav.setViewName("showUpdateEmployee");
	    }else{
	    	 mav.addObject("Message","Employee Not Found!!");
	 	    mav.setViewName("showUpdateEmployee");
	    }}catch(TechnicalException te){
	    	mav.addObject("Message","Some Technical Problem Occurred!!");
	 	     mav.setViewName("showUpdateEmployee");
	    }
	    
		return mav;
	}
	
	@RequestMapping(value="/updateEmp.do",method=RequestMethod.POST)
	public ModelAndView updateEmployee(@Valid final Employee employee,final BindingResult result){
		ModelAndView mav=new ModelAndView();
		
		if(result.hasErrors()){
			mav.setViewName("showUpdateEmployee");
		}else{
		try{
		if(employeeService.updateEmployee(employee)){
			mav.addObject("Message", "Employee Details Successfully Updated!!");
			mav.setViewName("showUpdateEmployee");
		}else{
			mav.addObject("Message", "Employee details Not Updated!!");
			mav.setViewName("showUpdateEmployee");
		}}catch(TechnicalException te){
	    	mav.addObject("Message","Some Technical Problem Occurred!!");
	 	     mav.setViewName("showUpdateEmployee");
	    }}
		return mav;
	}
	
		
	@RequestMapping(value="/delEmp.do",method=RequestMethod.GET)
	public ModelAndView deleteEmployee(@Valid final Employee employee,final BindingResult result){
		ModelAndView mav=new ModelAndView();
		try{
		if(employeeService.deleteEmployee(employee)){
			mav.addObject("Message", "Employee Successfully Deleted!!");
			mav.setViewName("redirect:/deleteEmployee.htm");
		}else{
			mav.addObject("Message", "Employee Does Not Exist!!");
			mav.setViewName("redirect:/deleteEmployee.htm");
		}}catch(TechnicalException te){
	    	mav.addObject("Message","Some Technical Problem Occurred!!");
	 	     mav.setViewName("redirect:/deleteEmployee.htm");
	    }
		return mav;
	}

	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public ModelAndView validate(@Valid final Login login,final BindingResult result){
		ModelAndView mav=new ModelAndView();
		
		if(result.hasErrors()){
			mav.setViewName("Home");
		}else{
		try{
		if(employeeService.validateLogin(login)){
			mav.setViewName("Success");
		}else{
			mav.addObject("Message", "Invalid LoginID Or Password");
			mav.setViewName("Home");
		}}catch(InvalidLoginException ile){
	    	mav.addObject("Message","Some Technical Problem Occurred!!");
	 	     mav.setViewName("Home");
	    }}
		return mav;
	}
	
	
	
}
