package com.example.mysoc.repository;

import com.example.mysoc.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepo extends MongoRepository<User,Long> {
}
