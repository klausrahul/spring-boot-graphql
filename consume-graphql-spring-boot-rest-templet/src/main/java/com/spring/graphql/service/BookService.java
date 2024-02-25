package com.spring.graphql.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.graphql.model.Book;
import com.spring.graphql.model.Root;

@Service
public class BookService {

	@Autowired
	@Qualifier("restTempletWithLogs")
	private RestTemplate restTemplate;

	public ArrayList<Book> getBooks() {

		String query = "query{allBooks{id author description}}";

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");

		String requestBody = "{\"query\":\"" + query + "\"}";
		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

		ResponseEntity<Root> responseEntity = restTemplate.exchange("http://localhost:8080/graphql", HttpMethod.POST,
				requestEntity, Root.class);

		/*
		 * ResponseEntity<Root> responseEntity =
		 * restTemplate.postForEntity("http://localhost:8080/graphql", requestEntity,
		 * Root.class);
		 */
		System.out.println("Response ::" + responseEntity.getBody().getData().getAllBooks());

		return responseEntity.getBody().getData().getAllBooks();

	}

	public Book getBooksId() {

		String query = "query($bookId:Int){ getBook(bookId:$bookId){ id title } }";

		int bookId = 1;

		String variables = String.format("{\"bookId\": %d }", bookId);

		// Build the GraphQL request
		String requestBody = String.format("{\"query\": \"%s\", \"variables\" : %s}", query, variables);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");

		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

		/*
		 * ResponseEntity<Root> responseEntity =
		 * restTemplate.exchange("http://localhost:8080/graphql", HttpMethod.POST,
		 * requestEntity, Root.class);
		 */

		ResponseEntity<Root> responseEntity = restTemplate.postForEntity("http://localhost:8080/graphql", requestEntity,
				Root.class);

		System.out.println("Response ::" + responseEntity.getBody().getData().getGetBook());

		return responseEntity.getBody().getData().getGetBook();

	}
}
