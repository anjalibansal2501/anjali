package com.project.libraraymanagement.models;

import javax.persistence.*;
import javax.persistence.Id;


//model class for Book
@Entity
@Table
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String book_name;
	
	@Column
	private String author;
	
	public enum Status { 
		AVAILABLE, ISSUED; 
	}
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	public Book(long id, String book_name, String author, Status status) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.author = author;
		this.status = status;
	}
	
	@Override
    public String toString() {
        return "Book [id=" + id + ", book_name=" + book_name + 
                ", author=" + author+ ", status=\" + status+ \"]";
    }
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Book() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	


}
