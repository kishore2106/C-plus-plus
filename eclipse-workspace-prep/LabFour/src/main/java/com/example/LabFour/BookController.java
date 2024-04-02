package com.example.LabFour;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/books")
public class BookController {
	private final List<Book> books = new ArrayList<Book>();
	
	@GetMapping
	public List<Book> getBooks(){
		return books;
	}
	
	@GetMapping("{id}")
	public Book getBook(@PathVariable Long id) {
		return findBookById(id);
	}
	
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		books.add(book);
		return book;
	}
	
	@PutMapping("{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
		Book existingBook = findBookById(id);
		if(existingBook != null) {
			existingBook.setName(book.getName());
			existingBook.setAuthor(book.getAuthor());
		}
		return existingBook;
	}
	
	@DeleteMapping("{id}")
	public void deleteBook(@PathVariable Long id, @RequestBody Book book) {
		Book existingBook = findBookById(id);
		if(existingBook != null) {
			books.remove(existingBook);
		}
	}
	
	private Book findBookById(Long id) {
		return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
	}
}
