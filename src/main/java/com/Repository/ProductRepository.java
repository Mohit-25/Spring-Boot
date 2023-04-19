package com.Repository;


import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{
	
	List<ProductEntity> findAll();
	List<ProductEntity> findByName(String name);

}
