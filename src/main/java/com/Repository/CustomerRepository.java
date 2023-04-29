package com.Repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.CustomerEntity;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer>{
	
	List<CustomerEntity> findAll();

	CustomerEntity findByCustomerId(Integer customerid);

}
