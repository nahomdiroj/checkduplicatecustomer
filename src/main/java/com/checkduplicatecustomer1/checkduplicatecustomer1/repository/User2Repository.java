package com.checkduplicatecustomer1.checkduplicatecustomer1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkduplicatecustomer1.checkduplicatecustomer1.entity.User2;

@Repository
public interface User2Repository extends JpaRepository<User2, Long> {
    Optional<User2> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    List<User2> findByPosition(String k);
}
