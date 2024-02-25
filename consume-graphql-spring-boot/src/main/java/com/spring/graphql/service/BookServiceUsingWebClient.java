package com.spring.graphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.spring.graphql.model.Book;
import com.spring.graphql.model.Root;

import graphql.ExecutionResult;
import reactor.core.publisher.Mono;

@Service
public class BookServiceUsingWebClient {

	
	@Autowired
	private WebClient webClient;
	
	
	
	
	public Mono<Root> callBookService() {
		System.out.println("Inside callBookService.......");
		String query ="query { getBook(bookId:1) { id author description } }";
		String requestBody = "{\"query\":\"" + query + "\"}";
		
		Mono<Root> s= webClient.post()
        .uri("http://localhost:8080/graphql").header("Content-Type", "application/json")
        .bodyValue(requestBody)
        .retrieve()
        .bodyToMono(Root.class).log();
		return s;
	}
	
	public Mono<Root> callBookServiceAll() {
		System.out.println("Inside callBookService.......");
		String query = "query{allBooks{id author description}}";
		String requestBody = "{\"query\":\"" + query + "\"}";
		
		Mono<Root> s= webClient.post()
        .uri("http://localhost:8080/graphql").header("Content-Type", "application/json")
        .bodyValue(requestBody)
        .retrieve()
        .bodyToMono(Root.class);
		return s;
	}

	public Mono<Root> getBooksAllVeriable() {
		String query = "query($bookId:Int){ getBook(bookId:$bookId){ id title } }";

		int bookId = 2;

		String variables = String.format("{\"bookId\": %d }", bookId);

		// Build the GraphQL request
		String requestBody = String.format("{\"query\": \"%s\", \"variables\" : %s}", query, variables);

		
		Mono<Root> s= webClient.post()
        .uri("http://localhost:8080/graphql").header("Content-Type", "application/json")
        .bodyValue(requestBody)
        .retrieve()
        .bodyToMono(Root.class);
		return s;
	}
}
