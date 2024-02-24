package com.spring.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Book {

	private int id;
	private String title;
	private String description;
	private String author;
	private double price;
	private int pages;
	
}
