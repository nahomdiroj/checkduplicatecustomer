package com.checkduplicatecustomer1.checkduplicatecustomer1.services;


import com.checkduplicatecustomer1.checkduplicatecustomer1.entity.TblSanctionCustomer;

import java.util.Collection;

public interface TblSanctionCustomerService {
      Collection<TblSanctionCustomer> findDeliquentByFullName(String fullName);

      Collection<TblSanctionCustomer> findSanctionByPhone(String name);
}
