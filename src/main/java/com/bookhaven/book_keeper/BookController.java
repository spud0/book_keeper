package com.bookhaven.book_keeper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	// 
	@GetMapping
	public ResponseEntity<String> getAllBooks () {	
		return new ResponseEntity<String> ("all the books", HttpStatus.OK);
	}

}

