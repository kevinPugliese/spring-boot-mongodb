package com.kevin.spring.mongodb.repositories;

import com.kevin.spring.mongodb.documents.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
