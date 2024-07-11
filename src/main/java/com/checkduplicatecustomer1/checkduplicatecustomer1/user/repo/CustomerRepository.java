package com.checkduplicatecustomer1.checkduplicatecustomer1.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkduplicatecustomer1.checkduplicatecustomer1.user.Customer;

import java.util.List;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>{
    List<Customer> findByName1StartsWithOrderByName1(String name1);

    List<Customer> findByName2StartsWith(String name2);

    List<Customer> findByMnemonicStartsWith(String Mnemonic);

    List<Customer> findByShortNameStartsWith(String shortName);

    List<Customer> findBySms1TelephoneStartsWith(String Sms1Telephone);
    List<Customer> findByMotherName(String motherName);

    List<Customer> findByCustomerId(String custId);

}
