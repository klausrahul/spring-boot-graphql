package com.spring.graphql.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.graphql.model.Book;
import com.spring.graphql.service.BookService;
@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	private BookService bookService;
	
	
	
	
	@GetMapping("/books")
	public ArrayList<Book> getBooks(){
		
		 return bookService.getBooks();
	}
	
	@GetMapping("/booksid")
	public Book getBooksId(){
		
		 return bookService.getBooksId();
	}

}
