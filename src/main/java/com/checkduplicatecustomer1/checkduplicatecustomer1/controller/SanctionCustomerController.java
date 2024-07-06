package com.checkduplicatecustomer1.checkduplicatecustomer1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;


import com.checkduplicatecustomer1.checkduplicatecustomer1.services.implementation.TblSanctionCustomerServiceImpl;
import com.checkduplicatecustomer1.checkduplicatecustomer1.util.ResponseCustomer;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sanction")
public class SanctionCustomerController {
    private TblSanctionCustomerServiceImpl sanctionCustomerService;

     @Autowired
    public SanctionCustomerController(TblSanctionCustomerServiceImpl sanctionCustomerService) {
        this.sanctionCustomerService = sanctionCustomerService;
    }



        @GetMapping("/fullname/{fullname}")
    public ResponseEntity<ResponseCustomer> getSanctionCustomerByFName(@PathVariable("fullname") String tin) {
        return ResponseEntity.ok(
                ResponseCustomer.builder()
                        .timeStamp(now())
                        .data(of("sanction customer", sanctionCustomerService.findDeliquentByFullName(tin)))
                        .message("Sanction Customer retrieved!")
                        .status(OK)
                        .build()
        );
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<ResponseCustomer> getSanctionCustomerByPhone(@PathVariable("phone") String tin) {
        return ResponseEntity.ok(
                ResponseCustomer.builder()
                        .timeStamp(now())
                        .data(of("sanction customer", sanctionCustomerService.findSanctionByPhone(tin)))
                        .message("Sanction Customer retrieved!")
                        .status(OK)
                        .build()
        );
    }
}
