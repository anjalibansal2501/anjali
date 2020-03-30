package com.project.libraraymanagement.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.project.libraraymanagement.models.Book;
import com.project.libraraymanagement.services.BookService;


@RestController
@RequestMapping("/book")
public class BookRestController {
	
	@Autowired
	private BookService bookService;
 
	//api to list all books
	@RequestMapping(value="/list_books" , method = RequestMethod.GET ,headers="Accept= application/json")
	public List<Book> listBooks() {
		List<Book> listBooks=bookService.getAllBooks();
	    return listBooks;
	}
	
	//api to add one or more books
	@RequestMapping(value="/add_books" , method = RequestMethod.POST, headers="Accept= application/json")
	public String addBooks(@RequestBody List<Book> book){
		String result = bookService.addBook(book);
		return result;
	}
	
	//api to issue a book
	@RequestMapping(value = "/issue_book/{id}", method = RequestMethod.PUT, headers="Accept= application/json")
    public String issueBook(@PathVariable("id") long id) {
		String result = bookService.issueBook(id);
        return result;
    }
	
	//api to return a book 
	@RequestMapping(value = "/return_book/{id}", method = RequestMethod.PUT, headers="Accept= application/json")
    public String returnBook(@PathVariable("id") long id) {
		String result = bookService.returnBook(id);
        return result;
    }
	
	//api to list all the issued books
	@RequestMapping(value="/list_issued_books" , method = RequestMethod.GET ,headers="Accept= application/json")
	public List<Book> listIssuedBooks() {
		List<Book> listBooks=bookService.getAllIssuedBooks();
		return listBooks;
		
	}
 
}