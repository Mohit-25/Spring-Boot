package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

	List<StudentEntity> findAll();

	StudentEntity findByStudentId(Integer empId);
}
