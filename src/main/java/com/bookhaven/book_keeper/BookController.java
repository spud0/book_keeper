package com.bookhaven.book_keeper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	@Autowired
	private BookService bookService;

	// testing
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks () {	
		return new ResponseEntity<List<Book>> (bookService.allBooks(), HttpStatus.OK);
	}

	// Returns JSON of all the books from a publisher	
	@GetMapping("/publishers/{publisherName}")	
	public ResponseEntity<List<Book>> getAllBooksForPublisher (@PathVariable String publisherName) {
		return new ResponseEntity<List<Book>> (bookService.allBooksForPublisher(publisherName), HttpStatus.OK);
	}

	// Returns JSON of all the books from a publisher	
	@GetMapping("/authors/{authorName}")	
	public ResponseEntity<List<Book>> getAllBooksForAuthor (@PathVariable String authorName) {
		return new ResponseEntity<List<Book>> (bookService.allBooksForAuthor(authorName), HttpStatus.OK);
	}
}
