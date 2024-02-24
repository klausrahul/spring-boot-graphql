package com.spring.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.graphql.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
