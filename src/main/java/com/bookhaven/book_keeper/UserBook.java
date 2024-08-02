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
@Table(name = "user_books")
@AllArgsConstructor
@NoArgsConstructor
public class UserBook{
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	

	@ManyToOne
	@JoinColumn(name="book_id", nullable=false)
	private Book book;

	@ManyToOne
	@JoinColumn(name="owner_id", nullable=false)
	private User owner;
	
	private int timesRead;	
	private int rating;	
	private String notes;

	@Column(name="added_at")
	private LocalDateTime addedAt;
}
