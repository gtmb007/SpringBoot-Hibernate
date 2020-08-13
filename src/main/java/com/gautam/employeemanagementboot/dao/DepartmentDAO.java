package com.gautam.employeemanagementboot.dao;

import java.util.List;
import java.util.Optional;

import com.gautam.employeemanagementboot.entity.Department;


public interface DepartmentDAO {
	
	public Integer addDepartment(Department dept) throws Exception;
	public Integer deleteDepartment(Integer deptId) throws Exception;
	public Optional<Department> getDepartment(Integer deptId) throws Exception;
	public Optional<List<Department>> getDepartments() throws Exception;
	
}
