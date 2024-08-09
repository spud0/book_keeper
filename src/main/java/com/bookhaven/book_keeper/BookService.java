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
		List<Book> books = bookRepository.findByAuthorName(authorName);
	
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));	
		}

		return books; 
	}	

	// All books from a publisher
 	public List<Book> allBooksForPublisher(String publisherName) {
		List<Book> books = bookRepository.findByPublisherName(publisherName);

		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));	
		}

		return books; 
	}

}
