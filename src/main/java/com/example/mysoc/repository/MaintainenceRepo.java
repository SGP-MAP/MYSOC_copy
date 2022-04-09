package com.example.mysoc.repository;

import com.example.mysoc.entity.MaintainenceDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaintainenceRepo extends MongoRepository<MaintainenceDB,Long> {
}