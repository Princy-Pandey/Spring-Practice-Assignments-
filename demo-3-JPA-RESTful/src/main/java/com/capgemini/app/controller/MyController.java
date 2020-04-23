package com.capgemini.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.entity.Book;
import com.capgemini.app.exception.BookException;
import com.capgemini.app.service.MyServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MyController {

	@Autowired
	private MyServiceInterface myService;

	@PostMapping("/book")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {

		Book bk = myService.save(book);

		return new ResponseEntity<Book>(bk, HttpStatus.OK);
	}

	@GetMapping("/getBooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> lb = myService.reterive();
		return new ResponseEntity<List<Book>>(lb, HttpStatus.OK);
	}
	
	@GetMapping("/delBook/{id}")
	public ResponseEntity<Boolean> delBook(@PathVariable("id") int id) {
		
		Boolean status = myService.delete(id);
		if(!status)throw new BookException("Book not found.");
		return new ResponseEntity<Boolean>(status, HttpStatus.OK);
	}
}
