package com.checkduplicatecustomer1.checkduplicatecustomer1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.OK;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import com.checkduplicatecustomer1.checkduplicatecustomer1.services.implementation.TblNSCRegistrationServiceImpl;
import com.checkduplicatecustomer1.checkduplicatecustomer1.util.ResponseCustomer;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ncsregistration")
public class NCSRegistrationCustomerController {


     private TblNSCRegistrationServiceImpl nscRegistrationService;

     
    @Autowired
    public NCSRegistrationCustomerController(TblNSCRegistrationServiceImpl nscRegistrationService) {
        this.nscRegistrationService = nscRegistrationService;
    }

    
    @GetMapping("/fullname/{fullname}")
    public ResponseEntity<ResponseCustomer> getSanctionCustomerByFName(@PathVariable("fullname") String tin) {
        return ResponseEntity.ok(
                ResponseCustomer.builder()
                        .timeStamp(now())
                        .data(of("Deliquent customer", nscRegistrationService.findDeliquentByFullName(tin)))
                        .message("Deliquent Customer retrieved!")
                        .status(OK)
                        .build()
        );
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<ResponseCustomer> getSanctionCustomerByPhone(@PathVariable("phone") String tin) {
        return ResponseEntity.ok(
                ResponseCustomer.builder()
                        .timeStamp(now())
                        .data(of("Deliquent customer", nscRegistrationService.findSanctionByPhone(tin)))
                        .message("Deliquent Customer retrieved!")
                        .status(OK)
                        .build()
        );
    }

    @GetMapping("/tin/{tin}")
    public ResponseEntity<ResponseCustomer> getSanctionCustomerByTin(@PathVariable("tin") String tin) {
        return ResponseEntity.ok(
                ResponseCustomer.builder()
                        .timeStamp(now())
                        .data(of("Deliquent customer", nscRegistrationService.findDeliquentByTin(tin)))
                        .message("Deliquent Customer retrieved!")
                        .status(OK)
                        .build()
        );
    }

}
