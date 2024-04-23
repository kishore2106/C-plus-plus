package com.example.TestThree;

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
@RequestMapping("/api/books")
public class BookController {
	private final List<Book> books = new ArrayList<Book>();
	
	@GetMapping
	public List<Book> getBooks(){
		return books;
	}
	
	@PostMapping
	public void addBook(@RequestBody Book book) {
		books.add(book);
	}
	
	@GetMapping("{id}")
	public Book getBook(@PathVariable Long id) {
		return findBookById(id);
	}
	
	private Book findBookById(Long id){
		return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
	}
	
//	public Book findBookById(Long id) {
//		Book book;
//		for(Book b: books) {
//			if(b.getId()==id) {
//				return b;
//			}
//		}
//		return books.get(0);
//	}
	
	@PutMapping("{id}")
	public void updateBook(@PathVariable Long id, @RequestBody Book book) {
		Book b = findBookById(id);
		b.setId(book.getId());
		b.setName(book.getName());
		b.setAuthor(book.getAuthor());
	}
	
	@DeleteMapping("{id}")
	public void deleteBook(@PathVariable Long id) {
		Book b = findBookById(id);
		books.remove(b);
	}
}
