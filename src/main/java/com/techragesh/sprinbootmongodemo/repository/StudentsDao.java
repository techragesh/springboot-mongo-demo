package com.techragesh.sprinbootmongodemo.repository;

import com.techragesh.sprinbootmongodemo.model.Students;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsDao extends MongoRepository<Students, Long> {

}
