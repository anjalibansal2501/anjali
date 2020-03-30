package com.project.libraraymanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.libraraymanagement.models.Book;
import com.project.libraraymanagement.models.Book.Status;
import com.project.libraraymanagement.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
    BookRepository repository;

	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = repository.findAll();
        if(bookList.size() > 0) {
            return bookList;
        } else {
            return new ArrayList<Book>();
        }	
	}
	
	@Override
	public List<Book> getAllIssuedBooks() {
		List<Book> bookList = repository.findAll();
		List<Book> issuedBookList = new ArrayList<Book>();
        if(bookList.size() > 0) {
        	 for (Book a : bookList) {
     	        if(a.getStatus() == Status.ISSUED)
     	        	issuedBookList.add(a);
     	     }
            return issuedBookList;
        } else {
            return new ArrayList<Book>();
        }	
	}
	
	@Override
	public Book findById(long id) {
		try {
			Optional<Book> book = repository.findById(id);
			return book.get();
		}
		catch (NoSuchElementException e) {
			return  null;
		}
	}
	
	@Override
	public String issueBook(long id) {
		Book book = findById(id);
        if (book == null) {
           return "There is no book with this ID.";
        }
        if(book.getStatus() == Status.ISSUED){
         String alreadyIssued = "Cannot be issued. Book with ID " + book.getId() + " and name "+ book.getBook_name() + " has already been issued to someone else.";
         return alreadyIssued;	
        }
        book.setStatus(Status.ISSUED);
        repository.save(book);
        String res = "Book with ID " + book.getId() + " and name "+ book.getBook_name() + " is issued.";
        return res;
	}
	
	@Override
	public String returnBook(long id) {
		Book book = findById(id);
		if (book == null) {
        	return "There is no book with this ID.";
        }
        if(book.getStatus() == Status.AVAILABLE){
        	String alreadyReturned = "Cannot be returned. Book with ID " + book.getId() + " and name "+ book.getBook_name() + " has already been returned before this.";
            return alreadyReturned;	
         }
        book.setStatus(Status.AVAILABLE);
        repository.save(book);
        String res = "Book with ID " + book.getId() + " and name "+ book.getBook_name() + " is returned and available now.";
        return res;
		
	}
	
	@Override
	public String addBook(List<Book> book) {
		for(Book b : book) {
			b.setStatus(Status.AVAILABLE);
			repository.save(b);
		}
		return "Books have been added successfully.";
		
	}
	
}