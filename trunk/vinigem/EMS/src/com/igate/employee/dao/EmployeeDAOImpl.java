package com.igate.employee.dao;


import java.util.List;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.igate.employee.exception.InvalidLoginException;
import com.igate.employee.exception.TechnicalException;
import com.igate.employee.forms.Employee;
import com.igate.employee.forms.Login;
@Repository("employeeDao")
public class EmployeeDAOImpl implements EmployeeDAO{
	
	private HibernateTemplate hibernateTemplate;
	private static final Logger LOGGER=Logger.getLogger("EmployeeDAOImpl");
	    
	@Autowired(required=true)		
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		
	}



	@SuppressWarnings("unchecked")
	public boolean validateLogin(final Login login) throws InvalidLoginException {
		try{
			final List<Login> loginList=hibernateTemplate.find("from Login order by loginId");
		   for(Login log:loginList){
			    if(login.getLoginID().equals(log.getLoginID())
					&& login.getPassword().equals(log.getPassword())){
				     LOGGER.info("User Found!!");
				     return true;
			       }
		}}catch(Exception e){
			LOGGER.info(e.getMessage());
			throw new InvalidLoginException(e.getMessage());
			
		}
		return false;
		
	}



	public boolean addEmployee(final Employee employee) throws TechnicalException {
		try{
			hibernateTemplate.saveOrUpdate(employee);
			LOGGER.info("Employee Details, having eid "+employee.getEid()+", Added!!");
			return true;
		}catch(Exception e){
			LOGGER.info(e.getMessage());
			throw new TechnicalException(e.getMessage());
			
		}
	}



	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() throws TechnicalException {
		try{
			return hibernateTemplate.find("from Employee order by eid");
		}catch(Exception e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException(e.getMessage());
		}
	}
	
	public Employee getEmployee(final String eid) throws TechnicalException {
		try{
			return hibernateTemplate.get(Employee.class, eid);
			}catch(Exception e){
			LOGGER.info(e.getMessage());
			throw new TechnicalException(e.getMessage());
		}
	}



	public boolean updateEmployee(final Employee employee) throws TechnicalException {
		try{
			hibernateTemplate.update(employee);
			LOGGER.info("Employee Details, having eid "+employee.getEid()+", Updated!!");
			return true;
			}catch(Exception e){
				LOGGER.info(e.getMessage());
				throw new TechnicalException(e.getMessage());
			}
	}



	public boolean deleteEmployee(final Employee employee) throws TechnicalException {
		try{
			hibernateTemplate.delete(employee);
			LOGGER.info("Employee Details, having eid "+employee.getEid()+", deleted!!");
			return true;
			}catch(Exception e){
				LOGGER.info(e.getMessage());
				throw new TechnicalException(e.getMessage());
			}
	}



	@SuppressWarnings("unchecked")
	public List<Employee> searchEmployee(final String eid) throws TechnicalException {
		try{
			final String query="from Employee WHERE eid LIKE ? order by eid";
			return  hibernateTemplate.find(query,eid+"%");
		}catch(Exception e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException(e.getMessage());
		}
	}


}
