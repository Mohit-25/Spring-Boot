package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer>{
	
	List<EmployeeEntity> findAll();

	EmployeeEntity findByEmpId(Integer empId);
	
	

}
