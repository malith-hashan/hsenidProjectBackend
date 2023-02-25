package com.example.servyTest1.Repository;

import com.example.servyTest1.models.Servey;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServeyRepository extends MongoRepository<Servey, String> {
    List<Servey> findByUserid(String id);
}
