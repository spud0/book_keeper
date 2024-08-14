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

	// Gets all the books stored in the DB... 
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
	
	// Returns the unique book based on its ISBN
	@GetMapping("/isbn/{isbnCode}")
	public ResponseEntity<Book> getBookFromIsbnCode (@PathVariable String isbnCode) {
		return new ResponseEntity<Book> (bookService.bookFromIsbnCode(isbnCode), HttpStatus.OK);
	}

	/* I Should probably move this to a commentService class */

	// Based on the ISBN code get all the reviews associated with a book
	@GetMapping("/isbn/{isbnCode}/reviews")
	public ResponseEntity<Book> getReviewsForBook (@PathVariable String isbnCode) {
		return new ResponseEntity<Book> (commentService.bookReviewsFromIsbnCode(isbnCode), HttpStatus.OK);
	}

	// Based on the ISBN code get all the reviews associated with a publisher
	@GetMapping("/isbn/{isbnCode}/reviews")
	public ResponseEntity<Book> getReviewsForBook (@PathVariable String isbnCode) {
		return new ResponseEntity<Book> (commentService.publisherReviewsFromIsbnCode(isbnCode), HttpStatus.OK);
	}
}
