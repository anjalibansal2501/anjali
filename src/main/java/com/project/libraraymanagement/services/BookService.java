package com.project.libraraymanagement.services;

import java.util.List;

import com.project.libraraymanagement.models.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	public List<Book> getAllIssuedBooks();
	public Book findById(long id);
	public String issueBook(long id);
	public String returnBook(long id);
	public String addBook(List<Book> book);

}