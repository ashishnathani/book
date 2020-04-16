package com.ashish.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ashish.book.entity.Book;
import com.ashish.book.entity.BookRequestParam;
import com.ashish.book.repository.BookRepository;
import com.ashish.book.service.BookService;
import com.ashish.book.specification.BookSpecification;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	/**
	 * Gets the books.
	 *
	 * @param pageable the pageable
	 * @return the books
	 */
	@Override
	public Page<Book> getBooks(final BookRequestParam bookRequestParam,final Pageable pageable) {
		BookSpecification bookSpecification = new BookSpecification(bookRequestParam);
		return bookRepository.findAll(bookSpecification,pageable);
	}

	/**
	 * Save book.
	 *
	 * @param book the book
	 * @return the book
	 */
	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

}
