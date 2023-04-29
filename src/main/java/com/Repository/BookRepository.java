package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer>{
	
   List<BookEntity> findAll();

   BookEntity findByBookId(Integer id);
   List<BookEntity> findByName(String name);

   List<BookEntity> findByAuthor(String author);
   List<BookEntity> findByPriceBetween(Integer min,Integer max);
   
   

	@Query(nativeQuery = true, value = "SELECT * FROM Book WHERE price < 0")
	List<BookEntity> getAllBooksByNgPrice();

	List<BookEntity> findByAuthorAndName(String author, String name);
	List<BookEntity> findAllByAvailableInd(boolean b);
}
