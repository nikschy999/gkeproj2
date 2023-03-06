package com.example.demo.Repositories;



import com.example.demo.users.StudentUser;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository

public interface studentUserRepo extends JpaRepository<StudentUser,String> {
    
}
