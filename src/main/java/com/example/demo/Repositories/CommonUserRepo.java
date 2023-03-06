package com.example.demo.Repositories;

import java.util.UUID;

import com.example.demo.secureLogins.commonUser;

import org.springframework.data.repository.CrudRepository;



public interface CommonUserRepo extends CrudRepository<commonUser,UUID> {
    
}
