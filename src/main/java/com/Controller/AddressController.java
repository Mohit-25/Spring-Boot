package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.AddressEntity;
import com.Repository.AddressRepository;

@RestController
public class AddressController {

	@Autowired
	AddressRepository addressrepository;
	
	@GetMapping("address")
	public List<AddressEntity> getallAddress()
	{
		return addressrepository.findAll();
	}
	
	@GetMapping("address/{addressid}")
	public AddressEntity getById(@PathVariable("addressid") Integer id)
	{
		Optional<AddressEntity> optional= addressrepository.findById(id);
		if(optional.isEmpty())
		{
			return null;
		}
		else
		{
			return optional.get();
		}
	}
	
	
	@PostMapping("/address")
	public AddressEntity addAddress(@RequestBody AddressEntity address) {
		addressrepository.save(address);
		return address;
	}
	
	@PutMapping("/address")
	public AddressEntity updateAddres(@RequestBody AddressEntity address)
	{ 
		addressrepository.save(address);
		return address; 
	}
	
	@DeleteMapping("/address/{id}")
	public AddressEntity deleteCustomer(@PathVariable("id") Integer id)
	{
		AddressEntity address= addressrepository.findById(id).get();
		addressrepository.deleteById(id);
		return address;
	}
}
