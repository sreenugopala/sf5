package com.sreenivaasamu.demoz.sf5.demo;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;

import com.sreenivaasamu.demoz.sf5.demo.entities.ClientDomain;
import com.sreenivaasamu.demoz.sf5.demo.repo.ClientDemoRepository;

@SpringBootApplication
public class MongoDemoLauncher {

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoLauncher.class, args);
	}

	@Bean
	CommandLineRunner init(ClientDemoRepository domainRepository) {

		return args -> {

			ClientDomain cd = new ClientDomain();
			cd.setDomain("sreenivasamu.com");

			Example<ClientDomain> example = Example.of(cd);
			Optional<ClientDomain> obj = domainRepository.findOne(example);
			System.out.println(obj.isPresent() ? obj.get() : "Is not present");

			ClientDomain obj2 = domainRepository.findFirstByDomain("sreenivaasa.com");
			System.out.println(obj2);

			if (obj.isPresent()) {
				long n = domainRepository.updateDomain("sreenivaasa.com", true);
				System.out.println("Number of records updated : " + n);
			} else {
				cd.setDisplayAds(true);
				cd = domainRepository.insert(cd);
				System.out.printf("Record Created %n");
			}
		};
	}
}