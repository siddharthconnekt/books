package com.example.books.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.books.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	public List<Book> findByTitleIgnoreCaseContaining(String title);
}
