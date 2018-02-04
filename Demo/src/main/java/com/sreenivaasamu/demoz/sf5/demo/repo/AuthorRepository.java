package com.sreenivaasamu.demoz.sf5.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.sreenivaasamu.demoz.sf5.demo.entities.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
