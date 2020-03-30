package com.project.libraraymanagement.models;

import javax.persistence.*;

//model class for Librarian
@Entity
@Table
public class Librarian{
   
	@Id
	private long id;
	
	@Column
	private String librarian_name;
	
	@Column
	private int age;
	
	@Override
    public String toString() {
        return "Librarian [id=" + id + ", librarian_name=" + librarian_name + 
                ", age=" + age+ "]";
    }

	public Librarian(long id, String librarian_name, int age) {
		super();
		this.id = id;
		this.librarian_name = librarian_name;
		this.age = age;
	}

	public Librarian() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibrarian_name() {
		return librarian_name;
	}

	public void setLibrarian_name(String librarian_name) {
		this.librarian_name = librarian_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
		

}
