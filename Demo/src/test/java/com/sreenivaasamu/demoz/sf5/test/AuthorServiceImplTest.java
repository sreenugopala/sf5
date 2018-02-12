package com.sreenivaasamu.demoz.sf5.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sreenivaasamu.demoz.sf5.demo.entities.Author;
import com.sreenivaasamu.demoz.sf5.demo.repo.AuthorRepository;
import com.sreenivaasamu.demoz.sf5.demo.service.AuthorService;
import com.sreenivaasamu.demoz.sf5.demo.service.impl.AuthorServiceImpl;
import com.sreenivaasamu.demoz.sf5.test.utils.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class AuthorServiceImplTest {
	
	private AuthorService authorService;
	
	@Mock
	AuthorRepository authorRepository;

	public AuthorServiceImplTest() {

		this.authorService = new AuthorServiceImpl(authorRepository);
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		log.debug("AuthorServiceImplTest.setUpBeforeClass");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		log.debug("AuthorServiceImplTest.tearDownAfterClass");
	}

	@BeforeEach
	void setUp() throws Exception {
		log.debug("AuthorServiceImplTest.setUp");
        MockitoAnnotations.initMocks(this);
        this.authorService = new AuthorServiceImpl(authorRepository);
        when(authorRepository.findAll()).thenReturn(Arrays.asList(new Author("Rod","Johnson"), new Author("Sreenu","Gopala")));
	}

	@AfterEach
	void tearDown() throws Exception {
		log.debug("AuthorServiceImplTest.tearDown");
	}

	@Test
	void testGetAllAuthors() {
		log.debug("AuthorServiceImplTest.setUpBeforeClass");
		assertNotNull(authorService, "Service Implementation Not wired");
		
		Iterable<Author> authors = authorService.getAllAuthors();
		List<Author> authorsList = new ArrayList<>();
		authors.iterator().forEachRemaining(authorsList::add);
		
		assertThat(authorsList.size() > 0);
		
		verify(authorRepository, times(1)).findAll();
		
		assertNotNull(authorsList.get(0));
		assertThat("Rod".equals(authorsList.get(0).getFirstName()));
		
		assertNotNull(authorsList.get(1));
		assertThat("Sreenu".equals(authorsList.get(1).getFirstName()));		
	}

}
