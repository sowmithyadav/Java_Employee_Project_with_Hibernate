package com.flm.dao;

import java.util.List;

import com.flm.entity.Employee;

public interface EmployeeDao {
	
	void saveEmployee(Employee emp);
	
	void updateEmployee(Employee emp);
	
	void deleteEmployee(int id);
	
	Employee getEmployee(int id);
	
	List<Employee> getAllEmployee();
	
	List<Employee> getAllEmployeeBasedOnSalary(int salary);
	
	int getMaxSalary();
	
	List<Employee> getAllEmployeeUsingSQL();
	
	List<Employee> getAllEmployeeBasedOnSalaryUsingSQL(int salary, String name);
	
	List<Object[]> getAllNamesAndSalaries();
	
	
	
	

}
