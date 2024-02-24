package com.spring.graphql.service;

import java.util.List;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.spring.graphql.model.Book;

import reactor.core.publisher.Mono;

@Service
public class BookService {

	
	
	
	private final HttpGraphQlClient graphQlClient ;

	public BookService() {
		WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080/graphql").build();
		graphQlClient=HttpGraphQlClient.builder(webClient).build();
	}
	
	public Mono<List<Book>> getBooks(){
		
		String query ="query{allBooks{id author description}}";
		
		System.out.println("query is  " + query);
		Mono<List<Book>> result=graphQlClient.document(query).retrieve("allBooks").toEntityList(Book.class);
		
		return result;
		
	}
	
	
	

	
	
	
}
