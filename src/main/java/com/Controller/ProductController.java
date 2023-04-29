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

import com.Entity.ProductEntity;
import com.Repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productrepository;
	
	@PostMapping("/product")
	public ProductEntity addproduct(@RequestBody ProductEntity product)
	{
		productrepository.save(product);
		return product; //id
	}
	
	@GetMapping("/product")
	public List<ProductEntity> givelist()
	{
		return productrepository.findAll();
		
	}
	
	@GetMapping("/product/{productid}")
	public ProductEntity findbyid(@PathVariable("productid") Integer id)
	{
		Optional<ProductEntity> optional=productrepository.findById(id);
		
		if(optional.isEmpty())
		{
			return null;
		}
		else
		{
			return optional.get();
		}
	}
	
	@GetMapping("/productname/{productname}")
	public List<ProductEntity> findbyName(@PathVariable("productname") String productname)
	{
		return productrepository.findByName(productname);
	}
	
	@DeleteMapping("/product/{productid}")
	public ProductEntity deletebyid(@PathVariable("productid") Integer id)
	{
		ProductEntity product= productrepository.findById(id).get();
		productrepository.deleteById(id);
		return product;
		
	}
	
	@PutMapping("/product")
	public ProductEntity update(@RequestBody ProductEntity product)
	{
		productrepository.save(product);
		return product;
	}
	
	
}
