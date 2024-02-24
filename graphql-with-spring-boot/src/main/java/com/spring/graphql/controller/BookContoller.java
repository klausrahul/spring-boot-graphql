package com.spring.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.graphql.entity.Book;
import com.spring.graphql.service.BookService;

@RestController
@RequestMapping("/books")
public class BookContoller {

	@Autowired
	private BookService bookService;
	
	
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}
	
	
	@GetMapping
	public List<Book> getAllBook() {
		return bookService.getAll();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable(name = "id") int id) {
		return bookService.getById(id);
	}
	
	
}
