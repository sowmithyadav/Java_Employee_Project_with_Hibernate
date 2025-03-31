package com.flm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.flm.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static Session sess;
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		// Session session = factory.openSession();
		// with the above line the session will be permitted to only this static block.
		// to use it in other methods also then we need a class variable
		sess = factory.openSession();;
		
	}
	
	
	@Override
	public void saveEmployee(Employee emp) {
		// removing config code redundancy using static block
		/*
		 * // 1st Step Configuration cfg = new Configuration();
		 * cfg.configure("/hibernate.cfg.xml");
		 * 
		 * // 2nd Step
		 * 
		 * SessionFactory factory = cfg.buildSessionFactory();
		 * 
		 * // 3rd Step
		 * 
		 * Session session = factory.openSession();
		 */
		
		Transaction Tx = sess.beginTransaction();

		sess.persist(emp);

		Tx.commit();

	}

	@Override
	public void updateEmployee(Employee emp) {
		// removing config code redundancy using static block
		/*
		 * // 1st Step Configuration cfg = new Configuration();
		 * cfg.configure("/hibernate.cfg.xml");
		 * 
		 * // 2nd Step
		 * 
		 * SessionFactory factory = cfg.buildSessionFactory();
		 * 
		 * // 3rd Step
		 * 
		 * Session session = factory.openSession();
		 */
		Transaction Tx = sess.beginTransaction();

		sess.merge(emp);

		Tx.commit();

	}

	@Override
	public void deleteEmployee(int id) {

		
		Transaction Tx = sess.beginTransaction();
		sess.remove(getEmployee(id));
		Tx.commit();

	}

	@Override
	public Employee getEmployee(int id) {
		// note for GET query no need of Transaction
		Employee emp = sess.get(Employee.class, id);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		Query<Employee> allEmployees = sess.createQuery("from Employee");

		return allEmployees.getResultList();
	}

	@Override
	public List<Employee> getAllEmployeeBasedOnSalary(int salary) {
		Query<Employee> allEmployees = sess.createQuery("from Employee where salary>=?1");
		
		allEmployees.setParameter(1, salary);

		// note : here salary means the Java Entity name give in the Employee hibernate config file
		return allEmployees.getResultList();
	}

	@Override
	public int getMaxSalary() {
		
		Query maxSalary = sess.createQuery("select max(salary) from Employee");
		
		return maxSalary.getFirstResult();
		
	}

	@Override
	public List<Employee> getAllEmployeeUsingSQL() {
		Query<Employee> allEmployees = sess.createNativeQuery("select * from Employee").addEntity(Employee.class);

		return allEmployees.getResultList();
	}

	@Override
	public List<Employee> getAllEmployeeBasedOnSalaryUsingSQL(int salary, String name) {
		Query<Employee> allEmployees = sess.createNativeQuery("select * from Employee where salary <= ?1 and name = ?2").addEntity(Employee.class);

		allEmployees.setParameter(1, salary);
		
		allEmployees.setParameter(2, name);
		
		return allEmployees.getResultList();
	}

	@Override
	public List<Object[]> getAllNamesAndSalaries() {
		

		Query<Object[]> allEmployees = sess.createQuery("select name, salary from Employee");

		return allEmployees.getResultList();
		
	}

	// code redundancy found in the hibernate config part using static instead



}
