package com.checkduplicatecustomer1.checkduplicatecustomer1.services;

import com.checkduplicatecustomer1.checkduplicatecustomer1.entity.TblNSCRegistration;

import java.util.Collection;

public interface TblNSCRegistrationService {
        Collection<TblNSCRegistration> findDeliquentByTin(String tin);

        Collection<TblNSCRegistration> findDeliquentByFullName(String fullName);

        Collection<TblNSCRegistration> findSanctionByPhone(String name);
}
