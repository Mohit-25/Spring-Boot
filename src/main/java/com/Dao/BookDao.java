package com.Dao;

import java.util.List;

import com.Entity.BookEntity;

public interface BookDao {
	
	List<BookEntity> searchCriteria(String name,Integer min,Integer max);

}
