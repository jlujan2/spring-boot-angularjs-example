package com.javainuse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.javainuse.entity.Book;
import com.javainuse.java.BookService;

@RestController
public class TestController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/welcome.html")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	
	@RequestMapping("/books")
	public List<Book> secondPage() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping("/hi")
	public String sayHi() {
		return "Hi";
	}
	
	@RequestMapping("books/{id}")
	public Book getBook(@PathVariable String id) {
		return bookService.getBook(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Book book) {
		bookService.addBook(book);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/books/{id}")
	public void updateBook(@RequestBody Book book, @PathVariable String id) {
		 bookService.updateBook(id, book);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/books/{id}")
	public void deleteBook(@PathVariable String id) {
		 bookService.deleteBook(id);
	}
}