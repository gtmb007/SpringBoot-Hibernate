package com.gautam.employeemanagementboot.dao;

import java.util.List;
import java.util.Optional;

import com.gautam.employeemanagementboot.entity.Employee;


public interface EmployeeManagementDAO {
	
	public Integer addEmployee(Employee emp) throws Exception;
	public Integer updateEmployee(Integer empId, Employee newEmp) throws Exception;
	public Integer deleteEmployee(Integer empId) throws Exception;
	public Optional<Employee> getEmployee(Integer empId) throws Exception;
	public Optional<List<Employee>> getEmployees() throws Exception;
	
}
