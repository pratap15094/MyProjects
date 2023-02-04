package com.mongo.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.demo.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer>{

}
