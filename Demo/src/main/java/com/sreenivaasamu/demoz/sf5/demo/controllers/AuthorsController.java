package com.sreenivaasamu.demoz.sf5.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sreenivaasamu.demoz.sf5.demo.repo.AuthorRepository;

@Controller
public class AuthorsController {
	
	AuthorRepository authorRepo;
	
	public AuthorsController(AuthorRepository authorRepo) {
		super();
		this.authorRepo = authorRepo;
	}

	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors", authorRepo.findAll());
		return "authors";
	}

}
