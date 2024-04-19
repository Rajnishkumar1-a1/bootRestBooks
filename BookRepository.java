package com.rest.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.rest.test.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{
	
	public Book findById(int id);

}
