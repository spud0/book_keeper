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


}
