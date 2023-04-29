package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.CourseEntity;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {


	List<CourseEntity> findAll();

	CourseEntity findByCourseId(Integer empId);
	List<CourseEntity> findByName(String name);
}
