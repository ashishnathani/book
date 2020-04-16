package com.ashish.book.entity;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import com.ashish.book.common.CustomDateTimeDeserilizer;
import com.ashish.book.common.CustomDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * The Class Book.
 */
@Entity
@Where(clause = "delete_date IS NULL")
public class Book {

	/** The id. */
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	/** The title. */
	private String title;

	/** The publication name. */
	private String publicationName;

	/** The author name. */
	private String authorName;

	/** The price. */
	private Double price;

	/** The pub date. */
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserilizer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date pubDate;

	/** The isbn. */
	private String isbn;

	/** The deleted date. */
	@JsonIgnore
	@Column(name = "deleteDate", insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserilizer.class)
	@Type(type = "org.hibernate.type.ZonedDateTimeType")
	private ZonedDateTime deletedDate = null;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
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
	 * Gets the pub date.
	 *
	 * @return the pub date
	 */
	public Date getPubDate() {
		return pubDate;
	}

	/**
	 * Sets the pub date.
	 *
	 * @param pubDate the new pub date
	 */
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
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
	 * Gets the deleted date.
	 *
	 * @return the deleted date
	 */
	public ZonedDateTime getDeletedDate() {
		return deletedDate;
	}

	/**
	 * Sets the deleted date.
	 *
	 * @param deletedDate the new deleted date
	 */
	public void setDeletedDate(final ZonedDateTime deletedDate) {
		this.deletedDate = deletedDate;
	}

}
