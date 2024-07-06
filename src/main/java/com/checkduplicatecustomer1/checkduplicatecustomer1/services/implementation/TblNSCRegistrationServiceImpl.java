package com.checkduplicatecustomer1.checkduplicatecustomer1.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkduplicatecustomer1.checkduplicatecustomer1.entity.TblNSCRegistration;
import com.checkduplicatecustomer1.checkduplicatecustomer1.repository.TblNSCRegistrationRepo;
import com.checkduplicatecustomer1.checkduplicatecustomer1.services.TblNSCRegistrationService;
import com.checkduplicatecustomer1.checkduplicatecustomer1.util.SpecialCahConverter;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;



@Service
@Transactional
@Slf4j
public class TblNSCRegistrationServiceImpl implements TblNSCRegistrationService{
        private TblNSCRegistrationRepo registrationRepo;

         @Autowired
    public TblNSCRegistrationServiceImpl(TblNSCRegistrationRepo registrationRepo) {
        this.registrationRepo = registrationRepo;
    }

        @Override
    public Collection<TblNSCRegistration> findDeliquentByTin(String tin) {
        log.info("Fetch deliquent customer by tin: {}", registrationRepo.findByTINStartsWith(tin));

        return registrationRepo.findByTINStartsWith(tin);
    }

    @Override
    public Collection<TblNSCRegistration> findDeliquentByFullName(String fullName) {
        SpecialCahConverter s = new SpecialCahConverter();
        String name = s.convertName(fullName);
        String namefinal = s.replaceSpecialChar(name);
        log.info("Fetch deliquent customer by full name: {}", registrationRepo.findByCustomerFullNameStartsWith(namefinal));

        return registrationRepo.findByCustomerFullNameStartsWith(namefinal);
    }

    @Override
    public Collection<TblNSCRegistration> findSanctionByPhone(String name) {
        log.info("Fetch deliquent customer by phone: {}", registrationRepo.findByBTelNoStartsWith(name));

        return registrationRepo.findByBTelNoStartsWith(name);
    }

}
