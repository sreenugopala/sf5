package com.sreenivaasamu.demoz.sf5.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sreenivaasamu.demoz.sf5.demo.entities.ClientDomain;

public interface ClientDemoRepository extends MongoRepository<ClientDomain, Long>, ClientDemoCustomRepository {

	ClientDomain findFirstByDomain(String domain);

	ClientDomain findByDomainAndDisplayAds(String domain, boolean displayAds);

    //Supports native JSON query string
    @Query("{domain:'?0'}")
    ClientDomain findCustomByDomain(String domain);

    @Query("{domain: { $regex: ?0 } })")
    List<ClientDomain> findCustomByRegExDomain(String domain);

}