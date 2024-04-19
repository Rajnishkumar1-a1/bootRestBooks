package com.rest.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.test.services.BookService;

import com.rest.test.entities.Book;



@RestController
public class BookController {


	@Autowired
	private BookService bookService;
	
	//TO GET ALL BOOK HANDLER.............
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return this.bookService.getAllBooks();
	}
	
	
	//FOR GETTING SINGLE BOOK HANDLER.............
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	
	//NEW BOOK HANDLER...........
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookService.addBook(book);
		return b;
	}
	
	
	
	//DELETE BOOK HANDLER.........
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		
		this.bookService.deleteBook(bookId);
		
	}
	
	
	
	
	//UPDATE BOOK HANDLER
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId")int bookId) {
		this.bookService.updateBook(book, bookId);
		
		return book;
		
	}

	

}
