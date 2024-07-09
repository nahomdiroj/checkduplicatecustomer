package com.checkduplicatecustomer1.checkduplicatecustomer1.services;



import java.util.Collection;
import java.util.List;

import com.checkduplicatecustomer1.checkduplicatecustomer1.customer.Customer;

public interface CustomerService {
    Customer create(Customer customer);

    Collection<Customer> list();

    Customer get(Long id);

    Customer update(Customer customer);

    Boolean delete(Long id);

    Collection<Customer> findDuplicateCustomer();

    Collection<Customer> findDuplicateCustomerByName2(String name2);

    Collection<Customer> findDuplicateCustomerByMnemonic(String mnemonic);

    Collection<Customer> findDuplicateCustomerByShortName(String shortName);

    Collection<Customer> findDuplicateCustomerBySms1Telephone(String sms1Telephone);
    Collection<Customer> findDuplicateCustomerByMotherName(String mName);

    Collection<Customer> findDuplicateCustomerByCustomerId(String customerId);

    List<Customer> findLastCustomerRecord();
}
