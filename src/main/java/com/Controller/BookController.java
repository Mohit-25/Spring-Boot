package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;

import com.Bean.ResponseBean;
import com.Dao.BookDaoImpl;
import com.Entity.BookEntity;
import com.Repository.BookRepository;

@CrossOrigin
@RestController
public class BookController {

	@Autowired
	BookRepository bookrepo;
	@Autowired
	BookDaoImpl bdi;
	
	@GetMapping("/book")
	public List<BookEntity> getallbooks()
	{
		
		return bookrepo.findAll();
	}
	
	@GetMapping("/book/{bookid}")
	public BookEntity getById(@PathVariable("bookid") Integer id)
	{
		
		BookEntity book= bookrepo.findByBookId(id);
		return book;
	}
	
	@GetMapping("/bookname/{bookname}")
	public List<BookEntity> getByName(@PathVariable("bookname") String name)
	{
		
		List<BookEntity> book= bookrepo.findByName(name);
		return book;
	}
	
	@GetMapping("/priceFilter/{min}/{max}")
	public List<BookEntity> getByPriceFilter(@PathVariable("min") Integer min, @PathVariable("max") Integer max)
	{
	     return bookrepo.findByPriceBetween(min, max);

	}
//	@GetMapping("/book/byPrice/")
//	public ResponseEntity<List<BookEntity>> searchBookByPrice(@RequestParam("min") Integer minPrice,
//																@RequestParam("max") Integer maxPrice) {
//		List<BookEntity> bookList = bookrepo.findByPriceBetween(minPrice, maxPrice);
//		
//		return ResponseEntity.ok(bookList);
//	} 
	

	@GetMapping("/book/available/{availability}")
	public ResponseEntity<List<BookEntity>> bookAvalability(@PathVariable boolean availability) {
		
		List<BookEntity> bookList = bookrepo.findAllByAvailableInd(availability);
		
		return ResponseEntity.ok(bookList);
		
	}
	
	@GetMapping("findngprice")
	public List<BookEntity> getbooks()
	{
		return bookrepo.getAllBooksByNgPrice();
	}
	
	@GetMapping("/search/{name}/{min}/{max}")
	public ResponseEntity<List<BookEntity>> search(@PathVariable("name") String name, @PathVariable("min") Integer min, @PathVariable("max") Integer max)
	{
		List<BookEntity> book=bdi.searchCriteria(name, min, max);
		return ResponseEntity.ok(book);
	}
	
//	
//	@PostMapping("/book")
//	public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity book) {
//		
//		List<BookEntity> booklist=bookrepo.findByAuthorAndName(book.getAuthor(), book.getName());
//		if(!booklist.isEmpty())
//		{
//			return ResponseEntity.unprocessableEntity().body(book); 
////			return new ResponseEntity<BookEntity>(book,HttpStatus.UNPROCESSABLE_ENTITY);
//		}
//		else
//		{
//			bookrepo.save(book);
//			return ResponseEntity.ok(book);
//			
//		}
//     }
	
	@PostMapping("/book")
	public ResponseEntity<ResponseBean<BookEntity>> addbook(@RequestBody BookEntity book)
	{
		 List<BookEntity> booklist= bookrepo.findByAuthorAndName(book.getAuthor(),book.getName());
		 ResponseBean<BookEntity> res=new ResponseBean<>();
		 if(booklist.isEmpty())
		 {
			
			 res.setData(book);
			 res.setMsg("Signup Done");
			 bookrepo.save(book);
			 return ResponseEntity.ok(res);
		 }
		 else
		 {
			 res.setData(book);
			 res.setMsg("Please Enter Valid Book");
			 return ResponseEntity.unprocessableEntity().body(res);
		 }
		
	}
	
	@PutMapping("/book")
	public BookEntity updateBook(@RequestBody BookEntity book)
	{ 
		bookrepo.save(book);
	    return book;

	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<BookEntity> deleteBook(@PathVariable("id") Integer id)
	{
		BookEntity book= bookrepo.findByBookId(id);
		bookrepo.deleteById(id);
		return ResponseEntity.ok(book);
	}
	

}
