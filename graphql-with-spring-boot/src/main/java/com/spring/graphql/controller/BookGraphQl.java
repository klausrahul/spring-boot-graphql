package com.spring.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.spring.graphql.entity.Book;
import com.spring.graphql.entity.BookInput;
import com.spring.graphql.service.BookService;

@Controller
public class BookGraphQl {

	@Autowired
	private BookService bookService;
	
	
	@MutationMapping("createBook")
	public Book createBook(@Argument BookInput book) {
		
		Book b=new Book();
		b.setTitle(book.getTitle());
		b.setDescription(book.getDescription());
		b.setAuthor(book.getAuthor());
		b.setPages(book.getPages());
		b.setPrice(book.getPrice());
		return bookService.createBook(b);
	}
	
	
	@QueryMapping("allBooks")
	public List<Book> getAllBook() {
		return bookService.getAll();
	}
	
	@QueryMapping("getBook")
	public Book getBookById(@Argument int bookId) {
		return bookService.getById(bookId);
	}
	
	
}
