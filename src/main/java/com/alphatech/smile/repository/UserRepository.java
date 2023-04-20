package com.alphatech.smile.repository;

import com.alphatech.smile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //findBy + fieldName
    Optional<User> findByUsername(String username);


//    List<User> getUsers
}
