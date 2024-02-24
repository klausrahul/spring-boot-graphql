package com.spring.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.graphql.entity.Book;
import com.spring.graphql.service.BookService;

@SpringBootApplication
public class GraphqlWithSpringBootApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(GraphqlWithSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Book b1=new Book();
		b1.setTitle("Complete Refrence");
		b1.setDescription("For Java");
		b1.setAuthor("XYZ");
		b1.setPages(100);
		b1.setPrice(200);
		
		
		Book b2=new Book();
		b2.setTitle("Complete Refrence c++");
		b2.setDescription("For C++");
		b2.setAuthor("ABC");
		b2.setPages(170);
		b2.setPrice(2000);
		
		
		Book b3=new Book();
		b3.setTitle("DSA with C++");
		b3.setDescription("DSA C++");
		b3.setAuthor("Rahul");
		b3.setPages(180);
		b3.setPrice(5000);
		
		bookService.createBook(b1);
		bookService.createBook(b2);
		bookService.createBook(b3);
		
	}

}
