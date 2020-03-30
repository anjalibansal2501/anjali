package com.project.libraraymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 
import com.project.libraraymanagement.models.Librarian;

@Repository
public interface LibrarianRepository 
	        extends JpaRepository<Librarian, Long> {
	 
}

