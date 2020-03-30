package com.project.libraraymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 
import com.project.libraraymanagement.models.Book;

@Repository
public interface BookRepository 
	        extends JpaRepository<Book, Long> {
	 
}
