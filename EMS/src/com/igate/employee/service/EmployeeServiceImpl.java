package com.igate.employee.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.igate.employee.dao.EmployeeDAO;
import com.igate.employee.exception.InvalidLoginException;
import com.igate.employee.exception.TechnicalException;
import com.igate.employee.forms.Employee;
import com.igate.employee.forms.Login;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	
	
	@Autowired(required=true)
	private EmployeeDAO employeeDAO;
	
	
		
	public boolean validateLogin(final Login login) throws InvalidLoginException{
		return employeeDAO.validateLogin(login);
		
	}

	public boolean addEmployee(final Employee employee) throws TechnicalException {
        return employeeDAO.addEmployee(employee);
	}

	
		public List<Employee> getAllEmployees() throws TechnicalException {
		return employeeDAO.getAllEmployees();
	}

	
	public Employee getEmployee(final String eid) throws TechnicalException {
		return employeeDAO.getEmployee(eid);
	}

	
	public boolean updateEmployee(final Employee employee) throws TechnicalException {
		return employeeDAO.updateEmployee(employee);
		
	}

	
	public boolean deleteEmployee(final Employee employee) throws TechnicalException {
		return employeeDAO.deleteEmployee(employee);
		
	}

	public List<Employee> searchEmployee(final String eid) throws TechnicalException {
		return employeeDAO.searchEmployee(eid);
	}

	

}
