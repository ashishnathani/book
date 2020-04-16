package com.ashish.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.book.entity.Book;
import com.ashish.book.entity.BookRequestParam;
import com.ashish.book.service.BookService;
@RestController
@RequestMapping("/v1/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	/** The guest order assembler. */
	@Autowired
	private PagedResourcesAssembler<Book> guestAssembler;

	@GetMapping("/search")
	public ResponseEntity<PagedResources<Resource<Book>>> getBooks(BookRequestParam bookRequestParam,Pageable pageable) {
		Page<Book> books = bookService.getBooks(bookRequestParam,pageable);
		return new ResponseEntity<>(guestAssembler.toResource(books), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
	}

}
