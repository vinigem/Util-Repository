package com.igate.employee.controller;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import com.igate.employee.forms.Employee;
import com.igate.employee.forms.Login;
public interface EmployeeController {
	

	public ModelAndView addEmployee(@Valid final Employee employee,final BindingResult result);
	public ModelAndView getEmployee(final Employee employee);
	public ModelAndView searchEmployee(final Employee employee);
	public ModelAndView getEmp(final Employee employee);
	public ModelAndView updateEmployee(@Valid final Employee employee,final BindingResult result);
	public ModelAndView deleteEmployee(@Valid final Employee employee,final BindingResult result);
	public ModelAndView validate(@Valid final Login login,final BindingResult result);

}
