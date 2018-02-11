package com.sreenivaasamu.demoz.sf5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;

import com.sreenivaasamu.demoz.sf5.demo.controllers.AuthorsController;
import com.sreenivaasamu.demoz.sf5.demo.service.AuthorService;
import com.sreenivaasamu.demoz.sf5.test.utils.MockitoExtension;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class AuthorsControllerTest {
	
	AuthorsController authorsController;
	
	@Mock
	AuthorService authorServiceImpl;
	
	@Mock
	Model model;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(getClass());
		
		authorsController = new AuthorsController(authorServiceImpl);
	}

	@Test
	void testGetAuthors() {
		
		String viewName = authorsController.getAuthors(model);
		
		assertEquals(viewName, "authors");
		
		verify(authorServiceImpl,times(1)).getAllAuthors();
		
		verify(model,times(1)).addAttribute(eq("authors"), anyIterable());
	}

}
