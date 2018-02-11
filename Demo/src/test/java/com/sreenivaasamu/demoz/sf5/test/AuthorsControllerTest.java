package com.sreenivaasamu.demoz.sf5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.sreenivaasamu.demoz.sf5.demo.controllers.AuthorsController;
import com.sreenivaasamu.demoz.sf5.demo.entities.Author;
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
		
		Set<Author> testAuthors = new HashSet<>();
		
		Author rama = new Author("Sree Raama", "Chandra");
		Author krishna = new Author("Sree Krishna", "Vaasudeva");
		testAuthors.add(rama);
		testAuthors.add(krishna);
		
		when(authorServiceImpl.getAllAuthors()).thenReturn(testAuthors);
	}

	@Test
	void testGetAuthors() {
		
        ArgumentCaptor<Set<Author>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

		
		String viewName = authorsController.getAuthors(model);
		
		assertEquals(viewName, "authors");
		
		verify(authorServiceImpl,times(1)).getAllAuthors();
		
		//verify(model,times(1)).addAttribute(eq("authors"), anyIterable());
		verify(model,times(1)).addAttribute(eq("authors"), argumentCaptor.capture());
				
		Set<Author> passedinAuthorSet = argumentCaptor.getValue();
		assertEquals(2, passedinAuthorSet.size(), "Number of Authors Mismatch");
		
		Author[] passedinAuthorArray = passedinAuthorSet.toArray(new Author[0]);
		
		assertEquals("Sree Raama", passedinAuthorArray[0].getFirstName(), "Authors FirstName Check");
		assertEquals("Vaasudeva", passedinAuthorArray[1].getLastName(), "Authors LastName Check");
	}
	
	@Test
	void testWebapp() throws Exception
	{
		 MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authorsController).build();

	        mockMvc.perform(get("/authors"));
	                //.andExpect(status());
	        		//.andExpect(view().name("authors"));
	}
}
