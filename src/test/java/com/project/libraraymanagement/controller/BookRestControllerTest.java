package com.project.libraraymanagement.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import com.project.libraraymanagement.models.Book;
import com.project.libraraymanagement.models.Book.Status;
import com.project.libraraymanagement.services.BookService;

@RunWith(MockitoJUnitRunner.class)
public class BookRestControllerTest {
	
	@InjectMocks
	BookRestController bookRestController;
     
    @Mock
    BookService bookService;
    
    
    @Test
    public void listBooksTest()
    {
        List<Book> list = new ArrayList<Book>();
        Book b1 = new Book(1, "Darkness to Light", "Lamar Odam", Status.AVAILABLE);
        Book b2 = new Book(2, "I Am Malala", "Christina Lamb", Status.ISSUED);
        Book b3 = new Book(7, "Obama-The Call of History", "Peter Baker", Status.AVAILABLE);
        list.add(b1);
        list.add(b2);
        list.add(b3);
         
        Mockito.when(bookService.getAllBooks()).thenReturn(list);
         
        //test
        List<Book> bookList = bookRestController.listBooks();
         
        assertEquals(3, bookList.size());
        assertEquals(b1, bookList.get(0));
        assertEquals(b2, bookList.get(1));
        assertEquals(b3, bookList.get(2));
        Mockito.verify(bookService, Mockito.times(1)).getAllBooks();
    }
    
    @Test
    public void addBooksTest()
    {
        List<Book> list = new ArrayList<Book>();
        Book b1 = new Book(6, "Whispers of Time", "Dr. Krishna Saksena", Status.AVAILABLE);
        Book b2 = new Book(9, "Game Changer", "Shahid Afridi", Status.AVAILABLE);
       
        list.add(b1);
        list.add(b2);
        
        String result = "Books have been added successfully.";
         
        Mockito.when(bookService.addBook(list)).thenReturn(result);
         
        //test
        String fetchedString = bookRestController.addBooks(list);
         
        assertEquals(fetchedString, result);
        Mockito.verify(bookService, Mockito.times(1)).addBook(list);
    }
    
    @Test
    public void issueBookTest()
    {
    	String res1 = "There is no book with this ID.";
    	String res2 = "Book with ID 2 is issued.";
    	Mockito.when(bookService.issueBook(123)).thenReturn(res1);
    	Mockito.when(bookService.issueBook(2)).thenReturn(res2);
    	 
    	//test
        String fetchedString1 = bookRestController.issueBook(123);
        String fetchedString2 = bookRestController.issueBook(2);
         
        assertEquals(fetchedString1, res1);
        assertEquals(fetchedString2, res2);
        Mockito.verify(bookService, Mockito.times(1)).issueBook(123);
        Mockito.verify(bookService, Mockito.times(1)).issueBook(2);
    	
    }
    
    @Test
    public void returnBookTest()
    {
    	String res1 = "There is no book with this ID.";
    	String res2 = "Cannot be returned. Book with ID 1 and name Darkness to Light has already been returned before this.";
    	String res3 = "Book with ID 2 and name I Am Malala is returned and available now.";
    	
    	Mockito.when(bookService.returnBook(123)).thenReturn(res1);
    	Mockito.when(bookService.returnBook(1)).thenReturn(res2);
    	Mockito.when(bookService.returnBook(2)).thenReturn(res3);
    	 
    	//test
        String fetchedString1 = bookRestController.returnBook(123);
        String fetchedString2 = bookRestController.returnBook(1);
        String fetchedString3 = bookRestController.returnBook(2);
         
        assertEquals(fetchedString1, res1);
        assertEquals(fetchedString2, res2);
        assertEquals(fetchedString3, res3);
        Mockito.verify(bookService, Mockito.times(1)).returnBook(123);
        Mockito.verify(bookService, Mockito.times(1)).returnBook(1);
        Mockito.verify(bookService, Mockito.times(1)).returnBook(2);
    	
    }
    
    @Test
    public void listIssuedBooksTest()
    {
        List<Book> list = new ArrayList<Book>();
        Book b1 = new Book(1, "Darkness to Light", "Lamar Odam", Status.ISSUED);
        Book b2 = new Book(2, "I Am Malala", "Christina Lamb", Status.ISSUED);
        list.add(b1);
        list.add(b2);
         
        Mockito.when(bookService.getAllIssuedBooks()).thenReturn(list);
         
        //test
        List<Book> bookList = bookRestController.listIssuedBooks();
         
        assertEquals(2, bookList.size());
        assertEquals(b1, bookList.get(0));
        assertEquals(b2, bookList.get(1));
        
        Mockito.verify(bookService, Mockito.times(1)).getAllIssuedBooks();
    }
    
    

}
