package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.DepartmentEntity;
import com.Repository.DepartmentRepository;
import com.Repository.EmployeeRepository;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentRepository deptrepo;
	
	@Autowired
	EmployeeRepository emprepo;
	
	@GetMapping("/department")
	public List<DepartmentEntity> getallDepartments()
	{
		
		return deptrepo.findAll();
	}
	
	@GetMapping("/department/{departmentid}")
	public DepartmentEntity getById(@PathVariable("departmentid") Integer departmentid)
	{
		
		DepartmentEntity department= deptrepo.findByDeptId(departmentid);
		return department;
	}
	
	
	@PostMapping("/department")
	public DepartmentEntity addDepartment(@RequestBody DepartmentEntity department) {
		
		deptrepo.save(department);
		return department;
	}
	
	@PutMapping("/department")
	public DepartmentEntity updateDepartment(@RequestBody DepartmentEntity department)
	{ 
		
		deptrepo.save(department);
		return department; 
	}
	
	@DeleteMapping("/department/{id}")
	public DepartmentEntity deleteDepartment(@PathVariable("id") Integer id)
	{
		DepartmentEntity department= deptrepo.findByDeptId(id);
		deptrepo.deleteById(id);
		return department;
	}
	
}
