package com.example.LabThree;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
	private final List<Book> books  = new ArrayList<Book>();
	
	@GetMapping
	public List<Book> getBooks() {
		return  books;
	}
	
	@GetMapping("{id}")
	public Book getBook(@PathVariable Long id){
		return findBookById(id);
	}
	
	private Book findBookById(Long id){
		return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
	}
	
	@PostMapping("{id}")
	public Book create(@PathVariable Long id, @RequestBody Book book) {
		books.add(book);
		return book;
	}
}
