package com.ashish.book.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import com.ashish.book.common.CustomDateTimeDeserilizer;
import com.ashish.book.common.CustomDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * The Class Topic.
 */
@Entity
@Where(clause = "delete_date IS NULL")
public class Topic {

	/** The id. */
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	/** The book id. */
	@Column(name = "book_id", updatable = false, insertable = false)
	private String bookId;

	/** The topic name. */
	private String topicName;
	
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
	 * Gets the book id.
	 *
	 * @return the book id
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * Sets the book id.
	 *
	 * @param bookId the new book id
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * Gets the topic name.
	 *
	 * @return the topic name
	 */
	public String getTopicName() {
		return topicName;
	}

	/**
	 * Sets the topic name.
	 *
	 * @param topicName the new topic name
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
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
