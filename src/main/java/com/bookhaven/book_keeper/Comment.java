package com.bookhaven.book_keeper;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	

	private String review;
	private int rating;	
	
	@ManyToOne
	@JoinColumn(name="book_id", nullable=false)
	private Book book;

	@ManyToOne
	@JoinColumn(name="owner_id", nullable=false)
	private User owner;
	
	@Column(name="added_at")	
	private LocalDateTime createdAt;	

}

