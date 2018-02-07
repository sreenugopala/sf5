package com.sreenivaasamu.demoz.sf5.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sreenivaasamu.demoz.sf5.demo.repo.BookRepository;

@Controller
public class BookController {

	private BookRepository bookRepo;

	public BookController(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "books";
	}
}
