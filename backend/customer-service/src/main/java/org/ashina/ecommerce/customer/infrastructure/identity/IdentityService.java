package org.ashina.ecommerce.customer.infrastructure.identity;

import org.ashina.ecommerce.customer.domain.Customer;

public interface IdentityService {

    void save(Customer customer, String password);
}
