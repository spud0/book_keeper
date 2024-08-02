package com.bookhaven.book_keeper;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	

	private String bookTitle;
	private String authorName;
	private String publisherName;
	private String blurb;	
	private String isbn;

	private int pageCount;
	private Date firstPublished;

}
