package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.DepartmentEntity;

@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Integer>{
	List<DepartmentEntity> findAll();

	DepartmentEntity findByDeptId(Integer departmentid);

	 List<DepartmentEntity> findByName(String name);
	

}
