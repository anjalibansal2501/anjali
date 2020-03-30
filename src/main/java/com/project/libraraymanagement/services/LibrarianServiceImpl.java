package com.project.libraraymanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.libraraymanagement.models.Librarian;
import com.project.libraraymanagement.repository.LibrarianRepository;



@Service
public class LibrarianServiceImpl implements LibrarianService{
	
	@Autowired
	LibrarianRepository repository;

	@Override
	public List<Librarian> getAllLibrarians() {
		List<Librarian> librarianList = repository.findAll();
        if(librarianList.size() > 0) {
            return librarianList;
        } else {
            return new ArrayList<Librarian>();
        }	
	}
	
	@Override
	public Librarian findById(long id) {
		try {
			Optional<Librarian> librarian = repository.findById(id);
			return librarian.get();
		}
		catch (NoSuchElementException e) {
			return  null;
		}	
	}
	
	@Override
	public String deleteLibrarian(long id) {
		if(findById(id) == null) {
			String noLibrarian = "The Librarian with the id "+ id + " does not exist";
			return noLibrarian;
		}
		repository.deleteById(id);
        String librarianDeleted = "The Librarian with the id " +  id + " has beed deleted.";
        return librarianDeleted;
	}
	
	@Override
	public String addLibrarian(Librarian librarian) {
		long id = librarian.getId();
		if(findById(id) != null) {
			String librarianExists = "The Librarian with the id "+ id + " already exists";
			return librarianExists;
		}
		repository.save(librarian);
		String librarianAdded = "The Librarian with the id " +  librarian.getId() + " has beed added.";
		return librarianAdded;
	}
	
}