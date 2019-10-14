package com.example.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.entity.Book;
import com.example.books.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/name")
	public List<Book> findByName(@RequestParam("name") String name) {
		return bookService.findByTitle(name);
	}

}
