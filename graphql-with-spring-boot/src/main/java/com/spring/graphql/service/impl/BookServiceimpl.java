package com.spring.graphql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.graphql.entity.Book;
import com.spring.graphql.repo.BookRepo;
import com.spring.graphql.service.BookService;

@Service
public class BookServiceimpl implements BookService {

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public List<Book> getAll() {
		return  bookRepo.findAll();
	}

	@Override
	public Book getById(int id) {
		return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book You are looking not avaliable on server"));
	}

}
