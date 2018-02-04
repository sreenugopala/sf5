package com.sreenivaasamu.demoz.sf5.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.sreenivaasamu.demoz.sf5.demo.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
