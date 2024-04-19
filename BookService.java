package com.rest.test.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.test.dao.BookRepository;

import com.rest.test.entities.Book;


@Component
public class BookService {
	

	@Autowired
	private BookRepository bookRepository;

//	private static List<Book> list = new ArrayList<>();f
//	
//	static {
//		list.add(new Book(12,"akljdfakljdf", "adasdf"));
//		list.add(new Book(13,"akljdff", "adf"));
//		list.add(new Book(14,"df", "adf"));
//	}
	
	
	
	//GET ALL BOOKS
	
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	
	//GET SINGLE BOOK BY ID
	
	public Book getBookById(int id){
		
		Book book = null;
		
		try {
			book = this.bookRepository.findById(id);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
	
	
	
	//TO ADDING NEW BOOK BY CLIENT
	
	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
	}
	
	
	
	
	
	//DELETE BOOK
	public void deleteBook(int bid) {
		bookRepository.deleteById(bid);
	}
	
	
	
	
	//UPDATE THE BOOK
	
	public void updateBook(Book book,int bookId) {
		
//		list.stream().map(b->{
//			
//			if(b.getId() == bookId) {
//				
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(bookId);
		bookRepository.save(book);
		
		
	}
	

}
