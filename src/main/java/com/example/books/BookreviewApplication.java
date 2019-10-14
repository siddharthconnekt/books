package com.example.books;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.books.service.BookService;

@SpringBootApplication
public class BookreviewApplication {

	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookreviewApplication.class, args);
		
	}
	
	@PostConstruct
	public void init() {
		bookService.loadBookData();
	}

}
