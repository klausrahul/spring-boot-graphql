package com.spring.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.graphql.model.Book;
import com.spring.graphql.service.BookService;
import com.spring.graphql.service.BookServiceUsingWebClient;

import graphql.ExecutionResult;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookServiceUsingWebClient bookServiceUsingWebClient;
	
	
	@GetMapping("/books")
	public Mono<List<Book>> getBooks(){
		
		return bookService.getBooks();
		//return bookServiceUsingWebClient.callBookService();
	}

	
}
