package com.techragesh.sprinbootmongodemo.repository;

import com.techragesh.sprinbootmongodemo.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends MongoRepository<Role, String> {

    Role findByRole(String role);
}
