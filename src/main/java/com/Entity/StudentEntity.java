package com.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Student")
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	private String name;
	private Integer age;
	
	//@JsonIgnor
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="student_course",joinColumns =@JoinColumn(name="studentId"),inverseJoinColumns = @JoinColumn(name="courseId"))
	List<CourseEntity> courses;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}
	
	
	

	
	
}
