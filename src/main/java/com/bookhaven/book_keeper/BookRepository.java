package com.bookhaven.book_keeper;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	// All books for a particular author	
 	public List<Book> findByAuthorName(String authorName);

	// All books for a particular publisher
 	public List<Book> findByPublisherName(String publisherName);

	// One book for ISBN code
	public Book findByIsbn(String Isbn);

	// One book for title, might have to change
	public Book findByBookTitle(String bookTitle);

	// All books with a specific page count
	public List<Book> findByPageCount (int pageCt);

}
