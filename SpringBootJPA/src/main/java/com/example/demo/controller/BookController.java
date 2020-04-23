package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;


@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookRepository bp;
	
	@PostMapping("/book")
	public ResponseEntity<Book> saveBook(@RequestBody Book b) {
		Book bk = bp.save(b);
		
		return new ResponseEntity<Book>(bk,HttpStatus.OK);
	}
	@GetMapping("/getBook/{bookId}")
    public ResponseEntity<Book> getBookId
              (@PathVariable("bookId") int id) {
		Optional<Book> b = bp.findById(id);
		if(b.isPresent()) {
			Book bk = b.get();
			return new ResponseEntity<Book>(bk,HttpStatus.OK);
		}
		return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/deleteBook/{bookId}")
    public ResponseEntity<Book> deleteBookId
              (@PathVariable("bookId") int id) {
		if(bp.existsById(id))
		{
			bp.deleteById(id);
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/getBookDetails")
    public ResponseEntity<List<Book>> getAllBookDetails() {
			List<Book> lstbook = bp.findAll();
			return new ResponseEntity<List<Book>>(lstbook,
					HttpStatus.OK);
	}
}
