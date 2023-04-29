package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.DepartmentEntity;
import com.Entity.EmployeeEntity;
import com.Repository.DepartmentRepository;
import com.Repository.EmployeeRepository;

@RestController
public class EmployeeController {

	
	@Autowired
	DepartmentRepository deptrepo;
	
	@Autowired
	EmployeeRepository emprepo;
	
	@GetMapping("/employee")
	public List<EmployeeEntity> getallemployees()
	{
		return emprepo.findAll();
	   
	}
	
	@GetMapping("/employee/{employeeid}")
	public EmployeeEntity getById(@PathVariable("employeeid") Integer employeeid)
	{
		
		EmployeeEntity employee= emprepo.findByEmpId(employeeid);
		return employee;
	}
	
	
	@PostMapping("/employee")
	public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employee) {
		
		
		List<DepartmentEntity> dept= deptrepo.findByName(employee.getDepartment().getName());
		if(!dept.isEmpty())
		{
			
			employee.getDepartment().setDeptId(dept.get(0).getDeptId()) ;
			employee.getDepartment().setName(null);
			emprepo.save(employee);
			System.out.println("dept not saved");
		
		}
		else
		{
			deptrepo.save(employee.getDepartment());
			emprepo.save(employee);
			System.out.println("dept saved");
			
		}
	
		return employee;
	}
	
//	@PutMapping("/employee")
//	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employee)
//	{ 
//		
//	}
	
	@DeleteMapping("/employee/{empId}")
	public EmployeeEntity deleteEmployee(@PathVariable("empId") Integer empId)
	{
		EmployeeEntity employee= emprepo.findByEmpId(empId);
		
		emprepo.deleteById(empId);
		return employee;
	}
}
