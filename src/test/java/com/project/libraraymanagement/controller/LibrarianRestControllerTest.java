package com.project.libraraymanagement.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import com.project.libraraymanagement.models.Librarian;
import com.project.libraraymanagement.services.LibrarianService;



@RunWith(MockitoJUnitRunner.class)
public class LibrarianRestControllerTest {
	
	@InjectMocks
	LibrarianRestController librarianRestController;
     
    @Mock
    LibrarianService librarianService;
    
    
    @Test
    public void listLibrariansTest()
    {
        List<Librarian> list = new ArrayList<Librarian>();
        Librarian l1 = new Librarian(1, "Anita", 26);
        Librarian l2 = new Librarian(2, "Shyaam", 41);
        Librarian l3 = new Librarian(3, "Ram", 36);
        list.add(l1);
        list.add(l2);
        list.add(l3);
         
        Mockito.when(librarianService.getAllLibrarians()).thenReturn(list);
         
        //test
        List<Librarian> librarianList = librarianRestController.listLibrarians();
         
        assertEquals(3, librarianList.size());
        assertEquals(l1, librarianList.get(0));
        assertEquals(l2, librarianList.get(1));
        assertEquals(l3, librarianList.get(2));
        Mockito.verify(librarianService, Mockito.times(1)).getAllLibrarians();
    }
    
    @Test
    public void addLibrarianTest()
    {
    	Librarian l1 = new Librarian(6, "Tina", 16);
        Librarian l2 = new Librarian(7, "Meena", 31);
        
        String librarianExists = "The Librarian with the id 6 already exists";
        String librarianAdded = "The Librarian with the id 7 has beed added.";
        
        Mockito.when(librarianService.addLibrarian(l1)).thenReturn(librarianExists);
        Mockito.when(librarianService.addLibrarian(l2)).thenReturn(librarianAdded);
        
        //test
        String fetchedString1 = librarianRestController.addLibrarian(l1);
        String fetchedString2 = librarianRestController.addLibrarian(l2);
        
        assertEquals(fetchedString1, librarianExists);
        assertEquals(fetchedString2, librarianAdded);
        Mockito.verify(librarianService, Mockito.times(1)).addLibrarian(l1);
        Mockito.verify(librarianService, Mockito.times(1)).addLibrarian(l2);
    }
    
    @Test
    public void deleteLibrarianTest()
    {
    	String noLibrarianExists = "The Librarian with the id 1 does not exist";
        String librarianDeleted = "The Librarian with the id 2 has beed deleted.";
        
        Mockito.when(librarianService.deleteLibrarian(1)).thenReturn(noLibrarianExists);
        Mockito.when(librarianService.deleteLibrarian(2)).thenReturn(librarianDeleted);
        
        //test
        String fetchedString1 = librarianRestController.deleteLibrarian(1);
        String fetchedString2 = librarianRestController.deleteLibrarian(2);
        
        assertEquals(fetchedString1, noLibrarianExists);
        assertEquals(fetchedString2, librarianDeleted);
        Mockito.verify(librarianService, Mockito.times(1)).deleteLibrarian(1);
        Mockito.verify(librarianService, Mockito.times(1)).deleteLibrarian(2);
    }
    
    
    

}
