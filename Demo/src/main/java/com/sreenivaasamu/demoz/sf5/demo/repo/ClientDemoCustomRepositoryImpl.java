package com.sreenivaasamu.demoz.sf5.demo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;
import com.sreenivaasamu.demoz.sf5.demo.entities.ClientDomain;

public class ClientDemoCustomRepositoryImpl implements ClientDemoCustomRepository {

  @Autowired
  MongoTemplate mongoTemplate;

  @Override
  public long updateDomain(String domain, boolean displayAds) {

      Query query = new Query(Criteria.where("clientdomain").is(domain));
      Update update = new Update();
      update.set("displayAds", displayAds);

      UpdateResult result = mongoTemplate.updateFirst(query, update, ClientDomain.class);

      if(result!=null)
          return result.getModifiedCount();
      else
          return 0L;

  }
}