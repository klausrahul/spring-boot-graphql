package com.spring.graphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.spring.graphql.model.Book;

import graphql.ExecutionResult;
import reactor.core.publisher.Mono;

@Service
public class BookServiceUsingWebClient {

	
	@Autowired
	private WebClient webClient;
	
	
	
	
	public Mono<Book> callBookService() {
		String query ="query { getBook(bookId:1) { id author description } }";
		
	
		
		return webClient.post()
				
        .uri("http://localhost:8080/graphql")
        .bodyValue(query)
        .retrieve()
        .bodyToMono(Book.class);

		
		
		
		//return result;
	}
}
