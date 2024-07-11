package com.checkduplicatecustomer1.checkduplicatecustomer1.services.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.checkduplicatecustomer1.checkduplicatecustomer1.services.CustomerService;
import com.checkduplicatecustomer1.checkduplicatecustomer1.user.Customer;

import com.checkduplicatecustomer1.checkduplicatecustomer1.user.CustomerResult;
import com.checkduplicatecustomer1.checkduplicatecustomer1.user.repo.CustomerRepository;
import com.checkduplicatecustomer1.checkduplicatecustomer1.user.repo.CustomerResultRepo;
import com.checkduplicatecustomer1.checkduplicatecustomer1.util.SpecialCahConverter;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepo;
   
    private CustomerResultRepo customerResultRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepo,
                            
                               CustomerResultRepo customerResultRepo) {
        this.customerRepo = customerRepo;

        this.customerResultRepo = customerResultRepo;
    }

    @Override
    public Customer create(Customer customer) {
        log.info("Saving new customer: {}", customer.getId());
        return customerRepo.save(customer);
    }

    @Override
    public Collection<Customer> list() {
        log.info("Fetching all customers: " + customerRepo.findAll().size());
        return customerRepo.findAll();
    }

    @Override
    public Customer get(Long id) {
        log.info("Fetching customer by nmnemonic: {} ", id);
        return customerRepo.findById(id).get();
    }

    @Override
    public Customer update(Customer customer) {
        log.info("Updating customer: {}", customer.getId());
        return customerRepo.save(customer);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("deleting customer by ID: {}", id);
        customerRepo.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public List<Customer> findDuplicateCustomer() {
        List<Customer> kk = new ArrayList<>();
        SearcherEngine ss = new SearcherEngine();
        
        
        List<String> result1 = new ArrayList<>();
//        myTestString.add("YARED HAILE KIYA");
//        myTestString.add("ABDUSELAM A/OLI A/FITA");
//        ss.getConsonants(name1);
     

        log.info(" showing result......" + result1.size());
        List<CustomerResult> cust = new ArrayList<>();
        for (String kks : result1) {
            CustomerResult cc = new CustomerResult();
            cc.setName(kks);
            cust.add(cc);
        }
        if (customerResultRepo.findAll().size() > 0) {
            customerResultRepo.deleteAll();
            for (CustomerResult j : cust) {
                customerResultRepo.save(j);
            }
        } else {
            for (CustomerResult j : cust) {
                customerResultRepo.save(j);
            }
        }

        log.info(" finding all customers : {}" + kk.size());
        return kk;
    }

    @Override
    public List<Customer> findDuplicateCustomerByName2(String name2) {
        log.info(" finding all customers that partially match name2: {}" + customerRepo.findByName2StartsWith(name2));
        return customerRepo.findByName2StartsWith(name2);
    }

    @Override
    public List<Customer> findDuplicateCustomerByMnemonic(String Mnemonic) {
        log.info(" finding all customers that partially match Mnemonic: {}" + customerRepo.findByMnemonicStartsWith(Mnemonic));
        return customerRepo.findByMnemonicStartsWith(Mnemonic);
    }


    @Override
    public List<Customer> findDuplicateCustomerByShortName(String shortName) {
        SpecialCahConverter s = new SpecialCahConverter();
        String name = s.convertName(shortName);
        String name1 = s.replaceSpecialChar(name);
//        String name1 = s.replaceSpecialChar(name);
        log.info(" finding all customers that partially match with shortName: {}" + customerRepo.findByShortNameStartsWith(name1));
        return customerRepo.findByShortNameStartsWith(name1);
    }


    @Override
    public List<Customer> findDuplicateCustomerBySms1Telephone(String Sms1Telephone) {
        log.info(" finding all customers that partially match Sms1Telephone: {}" + customerRepo.findBySms1TelephoneStartsWith(Sms1Telephone));
        return customerRepo.findBySms1TelephoneStartsWith(Sms1Telephone);
    }

    @Override
    public Collection<Customer> findDuplicateCustomerByMotherName(String mName) {
        log.info(" finding all customers that partially match mothername: {}" + customerRepo.findByMotherName(mName));
        return customerRepo.findByMotherName(mName);
    }

    @Override
    public List<Customer> findDuplicateCustomerByCustomerId(String custId) {
        log.info(" finding all customers that partially match customerId: {}" + customerRepo.findByCustomerId(custId));
        return customerRepo.findByCustomerId(custId);
    }

    @Override
    public List<Customer> findLastCustomerRecord() {
//        int k = customerRepo.findAll().size();
//        List<Customer> bbc = customerRepo.findAll();
        List<Customer> vv = customerRepo.findAll();

        return vv;

    }
}
