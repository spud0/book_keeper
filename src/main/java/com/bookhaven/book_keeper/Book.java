package com.bookhaven.book_keeper;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// import org.bson.types.ObjectId;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private String title;
	private String authorName;
	private String publisherName;
	private String descriptionBlurb;	
	private String ISBN;

	private long id;	
	private long timesRead;
	private long pageCount;

}
