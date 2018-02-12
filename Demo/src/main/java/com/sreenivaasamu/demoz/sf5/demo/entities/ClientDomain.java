package com.sreenivaasamu.demoz.sf5.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "clientdomain")
@Data
public class ClientDomain {

    @Id
    private long id;

    @Indexed(unique = true)
    private String domain;

    private boolean displayAds;
}