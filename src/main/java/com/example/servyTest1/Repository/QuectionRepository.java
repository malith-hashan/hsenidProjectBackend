package com.example.servyTest1.Repository;

import com.example.servyTest1.models.Quection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuectionRepository extends MongoRepository<Quection,String> {

}
