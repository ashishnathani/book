package com.ashish.book.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ashish.book.entity.Book;

@Repository
@Transactional
@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepository  extends JpaRepository<Book, String>, JpaSpecificationExecutor<Book>{

}
