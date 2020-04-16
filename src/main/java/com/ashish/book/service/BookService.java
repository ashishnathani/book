package com.ashish.book.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ashish.book.entity.Book;
import com.ashish.book.entity.BookRequestParam;

/**
 * The Interface BookService.
 */
public interface BookService {

	/**
	 * Save book.
	 *
	 * @param book the book
	 * @return the book
	 */
	Book saveBook(Book book);

	/**
	 * Gets the books.
	 *
	 * @param bookRequestParam the book request param
	 * @param pageable         the pageable
	 * @return the books
	 */
	Page<Book> getBooks(BookRequestParam bookRequestParam, Pageable pageable);

}
