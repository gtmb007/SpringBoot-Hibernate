package com.gautam.employeemanagementboot.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gautam.employeemanagementboot.entity.Employee;

@Repository("employeeDao")
public class EmployeeManagementDAOImpl implements EmployeeManagementDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Integer addEmployee(Employee emp) throws Exception {
		entityManager.persist(emp);
		return emp.getEmpId();
	}

	@Override
	public Integer updateEmployee(Integer empId, Employee newEmp) throws Exception {
		Employee emp=entityManager.find(Employee.class, empId);
		entityManager.remove(emp);
		entityManager.persist(newEmp);
		return newEmp.getEmpId();
	}

	@Override
	public Integer deleteEmployee(Integer empId) throws Exception {
		Employee emp=entityManager.find(Employee.class, empId);
		entityManager.remove(emp);
		return emp.getEmpId();
	}

	@Override
	public Optional<Employee> getEmployee(Integer empId) throws Exception {
		Employee dept=entityManager.find(Employee.class, empId);
		if(dept==null) return Optional.empty();
		return Optional.ofNullable(dept);
	}

	@Override
	public Optional<List<Employee>> getEmployees() throws Exception {
		String queryString ="select e from Employee e";
		Query query=entityManager.createQuery(queryString);
		List<Employee> result = query.getResultList();
		if(result==null || result.isEmpty()) return Optional.empty();
		return Optional.ofNullable(result);
	}

}