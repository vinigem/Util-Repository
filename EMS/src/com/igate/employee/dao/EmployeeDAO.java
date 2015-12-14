package com.igate.employee.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import com.igate.employee.exception.InvalidLoginException;
import com.igate.employee.exception.TechnicalException;
import com.igate.employee.forms.Employee;
import com.igate.employee.forms.Login;

public interface EmployeeDAO {
	
	 void setSessionFactory(SessionFactory sessionFactory);
	 boolean validateLogin(Login login) throws InvalidLoginException;
	 boolean addEmployee(Employee employee) throws TechnicalException ;
	 List<Employee> getAllEmployees() throws TechnicalException;
	 Employee getEmployee(String eid) throws TechnicalException ;
	 boolean updateEmployee(Employee employee) throws TechnicalException;
	 boolean deleteEmployee(Employee employee) throws TechnicalException;
	 List<Employee> searchEmployee(String eid) throws TechnicalException;

}
