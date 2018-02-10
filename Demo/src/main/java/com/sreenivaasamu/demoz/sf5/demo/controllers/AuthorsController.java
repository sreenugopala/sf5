package com.sreenivaasamu.demoz.sf5.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sreenivaasamu.demoz.sf5.demo.service.impl.AuthorServiceImpl;

@Controller
public class AuthorsController {
	
	private AuthorServiceImpl authorServiceImpl;
	
	@Autowired
	public AuthorsController(AuthorServiceImpl authorServiceImpl) {
		super();
		this.authorServiceImpl = authorServiceImpl;
	}

	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors", authorServiceImpl.getAllAuthors());
		return "authors";
	}

}
