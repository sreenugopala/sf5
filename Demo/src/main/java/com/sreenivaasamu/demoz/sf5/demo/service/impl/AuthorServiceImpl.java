package com.sreenivaasamu.demoz.sf5.demo.service.impl;

import org.springframework.stereotype.Service;

import com.sreenivaasamu.demoz.sf5.demo.entities.Author;
import com.sreenivaasamu.demoz.sf5.demo.repo.AuthorRepository;
import com.sreenivaasamu.demoz.sf5.demo.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {

	private AuthorRepository authorRepo;
	
	public AuthorServiceImpl(AuthorRepository authorRepo) {
		super();
		this.authorRepo = authorRepo;
	}

	@Override
	public Iterable<Author> getAllAuthors() {
		log.debug("Execution AuthorServiceImpl::{0} ", "getAllAuthors");
		return authorRepo.findAll();
	}

}
