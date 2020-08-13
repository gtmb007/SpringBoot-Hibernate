package com.gautam.employeemanagementboot.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gautam.employeemanagementboot.entity.Department;

@Repository("departmentDao")
public class DepartmentDAOImpl implements DepartmentDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Integer addDepartment(Department dept) throws Exception {
		entityManager.persist(dept);
		return dept.getDeptId();
	}

	@Override
	public Integer deleteDepartment(Integer deptId) throws Exception {
		Department dept=entityManager.find(Department.class, deptId);
		entityManager.remove(dept);
		return dept.getDeptId();
	}

	@Override
	public Optional<Department> getDepartment(Integer deptId) throws Exception {
		Department dept=entityManager.find(Department.class, deptId);
		if(dept==null) return Optional.empty();
		else return Optional.ofNullable(dept);
	}

	@Override
	public Optional<List<Department>> getDepartments() throws Exception {
		String queryString ="select d from Department d";
		Query query=entityManager.createQuery(queryString);
		List<Department> result = query.getResultList();
		if(result==null || result.isEmpty()) return Optional.empty();
		else return Optional.ofNullable(result);
	}

}
