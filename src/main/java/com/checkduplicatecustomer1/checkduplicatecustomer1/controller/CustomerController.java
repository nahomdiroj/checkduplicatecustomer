package com.checkduplicatecustomer1.checkduplicatecustomer1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.checkduplicatecustomer1.checkduplicatecustomer1.customer.ResponseCustomer;
import com.checkduplicatecustomer1.checkduplicatecustomer1.services.implementation.CustomerServiceImpl;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

//import com.example.serverdemo.utility.CSVHelper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {
  

    private CustomerServiceImpl customerService;

    @Autowired

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    public CustomerController() {

    }

    @GetMapping("/name")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseCustomer> getCustomer() {
        return ResponseEntity.ok(
                ResponseCustomer.builder()
                        .timeStamp(now())
                        .data(of("customer", customerService.findDuplicateCustomer()))
                        .message("Customer retrieved!")
                        .status(OK)
                        .build()
        );
    }

    @GetMapping("/mnemonic/{mnemonic}")
    public ResponseEntity<ResponseCustomer> getCustomerByMnemonic(@PathVariable("mnemonic") String mnemonic) {
        return ResponseEntity.ok(
                ResponseCustomer.builder()
                        .timeStamp(now())
                        .data(of("customer", customerService.findDuplicateCustomerByMnemonic(mnemonic)))
                        .message("Customer retrieved!")
                        .status(OK)
                        .build()
        );
    }

    @GetMapping("/shortName/{shortName}")
    public ResponseEntity<ResponseCustomer> getCustomerByShortName(@PathVariable("shortName") String shortName) {
        return ResponseEntity.ok(
                ResponseCustomer.builder()
                        .timeStamp(now())
                        .data(of("customer", customerService.findDuplicateCustomerByShortName(shortName)))
                        .message("Customer retrieved!")
                        .status(OK)
                        .build()
        );
    }

    @GetMapping("/sms1Telephone/{sms1Telephone}")
    public ResponseEntity<ResponseCustomer> getCustomerBysms1Telephone(@PathVariable("sms1Telephone") String sms1Telephone) {
        return ResponseEntity.ok(
                ResponseCustomer.builder()
                        .timeStamp(now())
                        .data(of("customer", customerService.findDuplicateCustomerBySms1Telephone(sms1Telephone)))
                        .message("Customer retrieved!")
                        .status(OK)
                        .build()
        );
    }

    @GetMapping("/motherName/{motherName}")
    public ResponseEntity<ResponseCustomer> getCustomerBymotherName(@PathVariable("motherName") String motherName) {
        return ResponseEntity.ok(
                ResponseCustomer.builder()
                        .timeStamp(now())
                        .data(of("customer", customerService.findDuplicateCustomerByMotherName(motherName)))
                        .message("Customer retrieved!")
                        .status(OK)
                        .build()
        );
    }

    @GetMapping("/customerId/{customerId}")
    public ResponseEntity<ResponseCustomer> getCustomerByCustomerId(@PathVariable("customerId") String custId) {
        return ResponseEntity.ok(
                ResponseCustomer.builder()
                        .timeStamp(now())
                        .data(of("customer", customerService.findDuplicateCustomerByCustomerId(custId)))
                        .message("Customer retrieved!")
                        .status(OK)
                        .build()
        );
    }

    @GetMapping("/get/name/{name2}")
    public ResponseEntity<ResponseCustomer> getCustomerByName2(@PathVariable("name2") String name2) {
        return ResponseEntity.ok(
                ResponseCustomer.builder()
                        .timeStamp(now())
                        .data(of("customer", customerService.findDuplicateCustomerByName2(name2)))
                        .message("Customer retrieved!")
                        .status(OK)
                        .build()
        );
    }
}

