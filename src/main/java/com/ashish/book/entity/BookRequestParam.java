package com.ashish.book.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ashish.book.common.CustomDateTimeDeserilizer;
import com.ashish.book.common.CustomDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * The Class BookRequestParam.
 */
public class BookRequestParam {

	/** The author name. */
	private String authorName;

	/** The isbn. */
	private String isbn;

	/** The publication name. */
	private String publicationName;

	/** The title. */
	private String title;

	/** The price. */
	private Double price;

	/** The from date time. */
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserilizer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fromDate;

	/** The to date time. */
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserilizer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date toDate;

	/**
	 * Gets the author name.
	 *
	 * @return the author name
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * Sets the author name.
	 *
	 * @param authorName the new author name
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * Gets the isbn.
	 *
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Sets the isbn.
	 *
	 * @param isbn the new isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Gets the publication name.
	 *
	 * @return the publication name
	 */
	public String getPublicationName() {
		return publicationName;
	}

	/**
	 * Sets the publication name.
	 *
	 * @param publicationName the new publication name
	 */
	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Gets the from date time.
	 *
	 * @return the from date time
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * Sets the from date time.
	 *
	 * @param fromDateTime the new from date time
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Gets the to date time.
	 *
	 * @return the to date time
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * Sets the to date time.
	 *
	 * @param toDateTime the new to date time
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
}
