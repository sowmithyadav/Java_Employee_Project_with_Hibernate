package com.flm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.flm.dao.EmployeeDao;
import com.flm.dao.EmployeeDaoImpl;
import com.flm.entity.Employee;

public class EmployeeTest {
	
 public static void main(String[] args)
 {
	 // using the below config in static block 
	 
		/*
		 * // 1st Step Configuration cfg = new Configuration();
		 * cfg.configure("/hibernate.cfg.xml");
		 * 
		 * //2nd Step
		 * 
		 * SessionFactory factory = cfg.buildSessionFactory();
		 * 
		 * // 3rd Step
		 * 
		 * Session session = factory.openSession(); Transaction Tx =
		 * session.beginTransaction();
		 * 
		 * Employee emp = new Employee(20,"Sowmith","Padmaroanagar",60000);
		 * 
		 * session.persist(emp);
		 * 
		 * 
		 * Tx.commit(); session.close();
		 */
	 
	 EmployeeDao  empDao = new EmployeeDaoImpl();
	 
	 Employee emp = new Employee(20,"Sowmith","Padmaroanagar",60000);
	 
	 empDao.saveEmployee(emp);
	 
	 System.out.print("Employee Saved");
	 
	 // type                  class which has those methods in it
	 
	 empDao.deleteEmployee(1);
	 
	 System.out.print("Employee Deleted");
	 
	 empDao.getEmployee(1);
	 
	 System.out.print("Get Employee");
	 
	 emp.setName("ABCD");
	 
	 empDao.updateEmployee(emp);
	 
	for(Employee employee : empDao.getAllEmployeeBasedOnSalary(12000))
	{
	System.out.println(emp);
	}
	 
	for( Object[] array : empDao.getAllNamesAndSalaries())
	{
	System.out.println("Name "+array[0] + " Salary" + array[1]);
	}
	 
	 
	 
	 
	 
 }
}
