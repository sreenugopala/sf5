package com.sreenivaasamu.demoz.sf5.test;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sreenivaasamu.demoz.sf5.demo.DemoLauncher;
import com.sreenivaasamu.demoz.sf5.demo.repo.BookRepository;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoLauncher.class)
//@DataJpaTest
@Slf4j
class DatastoreIntegrationTest {
	
	@Autowired
	BookRepository bookRepository;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testBooksRepository() {
		long noOfBooks = bookRepository.count(); 
		log.debug("Number of books {0}", noOfBooks);
		assertThat( noOfBooks == 0).isTrue();
	}

}
