package com.rest.test.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;




@Entity
@Table(name = "Books")
public class Book {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private int id ;
	
	
	private String title;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author author;
	
	
	public Book(int id, String title, Author author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}


	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", author=" + author + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
		
	
}
