package com.bookhaven.book_keeper;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// import org.bson.types.ObjectId;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private long id;	
	private String name;
	private String userEmail;

	private List<Book> books;
	
}
