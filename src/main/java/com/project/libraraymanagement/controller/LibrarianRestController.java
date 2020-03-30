package com.project.libraraymanagement.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.project.libraraymanagement.models.Librarian;
import com.project.libraraymanagement.services.LibrarianService;
 

@RestController
@RequestMapping("/librarian")
public class LibrarianRestController {
	
	@Autowired
	private LibrarianService librarianService;
	
	
	@RequestMapping(value="/list_librarians" , method = RequestMethod.GET ,headers="Accept= application/json")
	public List<Librarian> listLibrarians() {
		List<Librarian> listLibrarian=librarianService.getAllLibrarians();
		return listLibrarian;
	}
 
	
	@RequestMapping(value="/add_librarian" , method = RequestMethod.POST, headers="Accept= application/json")
	public String addLibrarian(@RequestBody Librarian librarian){
		String result = librarianService.addLibrarian(librarian);
		return result;
	}
	
		
	@RequestMapping(value = "/delete_librarian/{id}", method = RequestMethod.DELETE, headers="Accept= application/json")
    public String deleteLibrarian(@PathVariable("id") long id) {
		String result = librarianService.deleteLibrarian(id);
        return result;
    }
	

	
}