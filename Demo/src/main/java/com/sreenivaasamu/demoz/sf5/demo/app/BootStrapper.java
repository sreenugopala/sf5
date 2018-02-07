package com.sreenivaasamu.demoz.sf5.demo.app;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sreenivaasamu.demoz.sf5.demo.entities.Author;
import com.sreenivaasamu.demoz.sf5.demo.entities.Book;
import com.sreenivaasamu.demoz.sf5.demo.repo.AuthorRepository;
import com.sreenivaasamu.demoz.sf5.demo.repo.BookRepository;

@Component
public class BootStrapper implements ApplicationListener<ContextRefreshedEvent>{
	
/*	private AuthorRepository authorRepo;
	private BookRepository bookRepo;
*/	
/*
	public BootStrapper(AuthorRepository authorRepo, BookRepository bookRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
	}
*/
	@Override
	public void onApplicationEvent(ContextRefreshedEvent cre) {
		
		//loadDefaultData();
	}
/*	
	private void loadDefaultData()
	{
		Book bhagavadgeetha = new Book();
		bhagavadgeetha.setTitle("Bhagavad Geetha");
		bhagavadgeetha.setCopiesSold(Long.MAX_VALUE);
		bhagavadgeetha.setIsbn("000000001");

		Book tripurarahasya = new Book();
		tripurarahasya.setTitle("Tripuraa Rahasya");
		tripurarahasya.setCopiesSold(Long.MAX_VALUE/ 25);
		tripurarahasya.setIsbn("000000002");

		Book uddhavageetha = new Book();
		uddhavageetha.setTitle("Uddava Geetha");
		uddhavageetha.setCopiesSold(Long.MAX_VALUE);
		uddhavageetha.setIsbn("000000003");
		
		Author lord = new Author("Sree Krishna","Vaasudeva",5,null);
		Author vyasadeva = new Author("Vyaasa Deva","Parashara",4,null);
		Author haritayana = new Author("Haritaayana","Bhargava",4,null);
		
		Set<Book> divineSayings = new HashSet<>();
		divineSayings.add(bhagavadgeetha);
		divineSayings.add(uddhavageetha);
		
		Set<Book> divineTreasures = new HashSet<>();
		divineTreasures.add(tripurarahasya);
		
		lord.setBooks(divineSayings);
		haritayana.setBooks(divineTreasures);
		vyasadeva.setBooks(divineSayings);
		
		bhagavadgeetha.setAuthors(new HashSet<Author>(Arrays.asList(lord, vyasadeva)));
		uddhavageetha.setAuthors(new HashSet<Author>(Arrays.asList(lord, vyasadeva)));		
		tripurarahasya.setAuthors(new HashSet<Author>(Arrays.asList(haritayana)));
		
		authorRepo.saveAll(Arrays.asList(lord, vyasadeva,haritayana ));
		bookRepo.saveAll(Arrays.asList(bhagavadgeetha, uddhavageetha,tripurarahasya));
	}

*/}
