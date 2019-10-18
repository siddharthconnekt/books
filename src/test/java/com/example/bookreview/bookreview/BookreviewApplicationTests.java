package com.example.bookreview.bookreview;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.books.entity.Book;
import com.example.books.service.BookService;
import static org.junit.Assert.assertEquals;

public class BookreviewApplicationTests {
	
	@Autowired
	private BookService bookService;
	
	@Test
	public void testFindByTitle() {
		List<Book> books = bookService.findByTitle("Java");
		assertEquals("857300923712",books.get(0).getIsbn().toString());
	}

}
