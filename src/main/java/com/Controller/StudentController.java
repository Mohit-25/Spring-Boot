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
import com.Entity.StudentEntity;
import com.Repository.CourseRepository;
import com.Repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	CourseRepository courserepo;
	
	@Autowired
	StudentRepository studentrepo;
	
	@GetMapping("/student")
	public List<StudentEntity> getallstudents()
	{
		return studentrepo.findAll();
	   
	}
	
	@GetMapping("/student/{studentid}")
	public StudentEntity getById(@PathVariable("studentid") Integer id)
	{
		
		StudentEntity student= studentrepo.findByStudentId(id);
		return student;
	}
	
	
	@PostMapping("/student")
	public StudentEntity addstudent(@RequestBody StudentEntity student) {
		
		   
		   for(CourseEntity c:student.getCourses())
	       {
				   
			   List<CourseEntity> course= courserepo.findByName(c.getName());
		   
		      if(!course.isEmpty())
			  {
			    c.setCourseId(course.get(0).getCourseId());
				c.setName(null);
//				courserepo.save(c);
			  }
		     
	       }
			
		   
		   studentrepo.save(student);
		   return student;
		
		    

		
	}
	
//	@PutMapping("/employee")
//	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employee)
//	{ 
//		
//	}
	
	@DeleteMapping("/student/{studentId}")
	public StudentEntity deleteStudent(@PathVariable("studentId") Integer Id)
	{
		StudentEntity student=studentrepo.findByStudentId(Id);
		
		studentrepo.deleteById(Id);
		return student;
	}
}
