package com.example.books.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.books.dao.BookRepository;
import com.example.books.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private ObjectMapper objectMapper;

	public void loadBookData() {}

	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitleIgnoreCaseContaining(title);
	}
	
	
}
