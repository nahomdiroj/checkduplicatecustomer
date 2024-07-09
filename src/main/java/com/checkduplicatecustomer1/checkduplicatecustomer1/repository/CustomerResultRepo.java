package com.checkduplicatecustomer1.checkduplicatecustomer1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkduplicatecustomer1.checkduplicatecustomer1.customer.CustomerResult;

@Repository
public interface CustomerResultRepo extends JpaRepository<CustomerResult, Long> {
}
