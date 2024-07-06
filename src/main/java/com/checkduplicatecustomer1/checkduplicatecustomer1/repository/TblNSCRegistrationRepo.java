package com.checkduplicatecustomer1.checkduplicatecustomer1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkduplicatecustomer1.checkduplicatecustomer1.entity.TblNSCRegistration;
import java.util.List;

public interface TblNSCRegistrationRepo   extends JpaRepository<TblNSCRegistration, Integer>{
    List<TblNSCRegistration> findByTINStartsWith(String tin);

    List<TblNSCRegistration> findByCustomerFullNameStartsWith(String fullName);

    List<TblNSCRegistration> findByBTelNoStartsWith(String phone);
}
