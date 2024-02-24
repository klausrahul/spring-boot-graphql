package com.spring.graphql.service;

import java.util.List;

import com.spring.graphql.entity.Book;

public interface BookService {
	
	Book createBook(Book book);
	
	List<Book> getAll();
	
	Book getById(int id);
	

}
