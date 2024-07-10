package com.checkduplicatecustomer1.checkduplicatecustomer1.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkduplicatecustomer1.checkduplicatecustomer1.entity.TblSanctionCustomer;
import java.util.List;


public interface TblSanctionCustomerRepo extends JpaRepository<TblSanctionCustomer, Integer>{
    List<TblSanctionCustomer> findByCustomerFullNameStartsWith(String fullName);

    List<TblSanctionCustomer> findByTelephoneStartsWith(String phone);
}
