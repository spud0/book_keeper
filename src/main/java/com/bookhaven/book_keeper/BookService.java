package com.bookhaven.book_keeper;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service 
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	// Testing purposes
	public List<Book> allBooks () {
		return bookRepository.findAll();
	}
	
	// All books written by an Author
	public List <Book> allBooksForAuthor (String authorName) {
		return bookRepository.findByAuthorName(authorName);
	}	

	// All books from a publisher
 	public List<Book> allBooksForPublisher(String publisherName) {
		return bookRepository.findByPublisherName(publisherName);
	}

	// One book based on ISBN	
	public Book bookFromIsbnCode (String isbnCode) {
		return bookRepository.findByIsbn(isbnCode);
	}

}
