package com.javainuse.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	private List<Book> books = new ArrayList<>(Arrays.asList(
			new Book("Amor en tiempos del coler","gabo","novela"),
			new Book("guerra del fin del mundo","mario","drama"),
			new Book("angels and demons","dan brown","drama")));
	
	public List<Book> getAllBooks() {
		return books;
	}
	
	public Book getBook(String id) {
		return books.stream().filter(t -> t.getName().equals(id)).findFirst().get();
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void updateBook(String id, Book book) {
		for(int i=0; i<books.size(); i++) {
			Book b = books.get(i);
			if(b.getName().equals(id)) {
				books.set(i, book);
				return;
			}
		}
	}
	
	public void deleteBook(String id) {
		books.removeIf(t -> t.getName().equals(id));
	}
	
	
}
