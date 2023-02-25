package com.example.servyTest1.Repository;

import com.example.servyTest1.models.ERole;
import com.example.servyTest1.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {

    Optional<Role> findByName(ERole name);
}
