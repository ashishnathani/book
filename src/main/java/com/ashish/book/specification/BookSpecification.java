package com.ashish.book.specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;

import com.ashish.book.entity.Book;
import com.ashish.book.entity.BookRequestParam;

/**
 * The Class BookSpecification.
 */
public class BookSpecification implements Specification<Book> {
	
	private static final long serialVersionUID = 8522797454588657490L;


	/** The from date. */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private final Date fromDate;

	/** The to date. */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private final Date toDate;

	/** The title. */
	private final String title;

	/** The author name. */
	private final String authorName;

	/** The isbn. */
	private final String isbn;

	/** The publication name. */
	private final String publicationName;

	/** The price. */
	private final Double price;

	/**
	 * Instantiates a new book specification.
	 *
	 * @param bookRequestParam the book request param
	 */
	public BookSpecification(BookRequestParam bookRequestParam) {
		super();
		if(Objects.nonNull(bookRequestParam.getFromDate())) {
			fromDate = bookRequestParam.getFromDate();
		}
		else {
			fromDate = null; 
		}
		
		if(Objects.nonNull(bookRequestParam.getToDate())) {
			toDate = bookRequestParam.getToDate();
		}
		else {
			toDate = null; 
		}
		title = bookRequestParam.getTitle();
		price = bookRequestParam.getPrice();
		publicationName = bookRequestParam.getPublicationName();
		authorName = bookRequestParam.getAuthorName();
		isbn = bookRequestParam.getIsbn();
	}

	/**
	 * To predicate.
	 *
	 * @param root            the root
	 * @param query           the query
	 * @param criteriaBuilder the criteria builder
	 * @return the predicate
	 */
	@Override
	public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		final List<Predicate> predicates = new ArrayList<>();

		if (Objects.nonNull(authorName)) {
			predicates.add(criteriaBuilder.equal(root.get("authorName"), authorName));
		}

		if (Objects.nonNull(title)) {
			predicates.add(criteriaBuilder.equal(root.get("title"), title));
		}

		if (Objects.nonNull(price)) {
			predicates.add(criteriaBuilder.equal(root.get("price"), price));
		}

		if (Objects.nonNull(publicationName)) {
			predicates.add(criteriaBuilder.equal(root.get("publicationName"), publicationName));
		}

		if (Objects.nonNull(authorName)) {
			predicates.add(criteriaBuilder.equal(root.get("authorName"), authorName));
		}

		if (Objects.nonNull(isbn)) {
			predicates.add(criteriaBuilder.equal(root.get("isbn"), isbn));
		}

		if (fromDate != null && toDate != null) {
			predicates.add(criteriaBuilder.between(root.get("pubDate"), fromDate, toDate));
		} else if (fromDate != null) {
			predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("pubDate"), fromDate));
		} else if (toDate != null) {
			predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("pubDate"), toDate));
		}

		// only unique records to be returned

		query.distinct(true);

		// add all predicates to save query

		if (!CollectionUtils.isEmpty(predicates)) {
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		}
		// return null if all parameters are null
		return null;
	}

}
