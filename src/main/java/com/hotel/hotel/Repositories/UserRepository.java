package com.hotel.hotel.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.hotel.Entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
