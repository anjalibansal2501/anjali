package com.project.libraraymanagement.services;

import java.util.List;
import com.project.libraraymanagement.models.Librarian;

public interface LibrarianService {

	public List<Librarian> getAllLibrarians();
	
	public String addLibrarian(Librarian librarian);
	
	public Librarian findById(long id);
	
	public String deleteLibrarian(long id) ;

}
