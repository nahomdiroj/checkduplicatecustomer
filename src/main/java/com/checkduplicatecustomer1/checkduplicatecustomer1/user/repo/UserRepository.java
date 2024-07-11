package com.checkduplicatecustomer1.checkduplicatecustomer1.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkduplicatecustomer1.checkduplicatecustomer1.user.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUsername(String username);

}
