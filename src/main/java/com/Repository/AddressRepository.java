package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.AddressEntity;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {

	List<AddressEntity> findAll();
}
