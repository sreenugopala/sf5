package com.sreenivaasamu.demoz.sf5.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sreenivaasamu.demoz.sf5.demo.service.AuthorService;

@Controller
public class AuthorsController {
	
	private AuthorService authorService;
	
	@Autowired
	public AuthorsController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}

	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors", authorService.getAllAuthors());
		return "authors";
	}

}
