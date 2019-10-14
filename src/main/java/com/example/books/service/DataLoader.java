package com.example.books.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.books.dao.BookRepository;
import com.example.books.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
    private BookRepository bookRepository;
	@Autowired
	private ObjectMapper objectMapper;
	
    public void run(ApplicationArguments args) {
		
		try(InputStream is = getClass().getResourceAsStream("/test.json");
				BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			List<Book> books = objectMapper.readValue(br, objectMapper.getTypeFactory().constructCollectionType(List.class, Book.class));
			bookRepository.saveAll(books);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    @PostConstruct
	public void init() {
		objectMapper.registerModule(new JavaTimeModule());
	}
}