package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.CourseEntity;
import com.Repository.CourseRepository;
import com.Repository.StudentRepository;

@RestController
public class CourseController {
	@Autowired
	CourseRepository courserepo;
	
	@Autowired
	StudentRepository studentrepo;
	
	@GetMapping("/course")
	public List<CourseEntity> getallcourses()
	{
		return courserepo.findAll();
	   
	}
	
	@GetMapping("/course/{courseid}")
	public CourseEntity getById(@PathVariable("courseid") Integer id)
	{
		
		CourseEntity course= courserepo.findByCourseId(id);
		return course;
	}
	
	
	@PostMapping("/course")
	public CourseEntity addCourse(@RequestBody CourseEntity course) {
		
		
		
		
			
			courserepo.save(course);
			return course;
		
	}
	
//	@PutMapping("/employee")
//	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employee)
//	{ 
//		
//	}
	
	@DeleteMapping("/course/{courseId}")
	public CourseEntity deleteCourse(@PathVariable("courseId") Integer Id)
	{
		CourseEntity course= courserepo.findByCourseId(Id);
		
		courserepo.deleteById(Id);
		return course;
	}

}
