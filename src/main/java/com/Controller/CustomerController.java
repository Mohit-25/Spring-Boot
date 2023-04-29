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

import com.Entity.CustomerEntity;
import com.Repository.AddressRepository;
import com.Repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerrepository;
	@Autowired
	AddressRepository addressrepository;
	
	@GetMapping("customer")
	public List<CustomerEntity> getallCustomers()
	{
		
		return customerrepository.findAll();
	}
	
	@GetMapping("customer/{customerid}")
	public CustomerEntity getById(@PathVariable("customerid") Integer customerid)
	{
		
		CustomerEntity customer= customerrepository.findByCustomerId(customerid);
		System.out.println(customer);
		return customer;
	}
	
	
	@PostMapping("/customer")
	public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
		addressrepository.save(customer.getAddress());
		customerrepository.save(customer);
		return customer;
	}
	
	@PutMapping("/customer")
	public CustomerEntity updateCustomer(@RequestBody CustomerEntity customer)
	{ 
		addressrepository.save(customer.getAddress());
		customerrepository.save(customer);
		return customer; 
	}
	
	@DeleteMapping("/customer/{id}")
	public CustomerEntity deleteCustomer(@PathVariable("id") Integer id)
	{
		CustomerEntity customer= customerrepository.findByCustomerId(id);
		int aid= customer.getAddress().getAddressId();
		customerrepository.deleteById(id);
		addressrepository.deleteById(aid);
		return customer;
	}
	
	
	

}
