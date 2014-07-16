package com.igate.employee.service;

import java.util.List;
import com.igate.employee.exception.InvalidLoginException;
import com.igate.employee.exception.TechnicalException;
import com.igate.employee.forms.Employee;
import com.igate.employee.forms.Login;

public interface EmployeeService {
	 boolean validateLogin(final Login login) throws InvalidLoginException;
	 boolean addEmployee(final Employee employee) throws TechnicalException;
	 List<Employee> getAllEmployees() throws TechnicalException;
	 Employee getEmployee(final String eid) throws TechnicalException;
	 boolean updateEmployee(final Employee employee) throws TechnicalException;
	 boolean deleteEmployee(final Employee employee) throws TechnicalException;
	 List<Employee> searchEmployee(String eid) throws TechnicalException;

}
