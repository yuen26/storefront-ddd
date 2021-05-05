package org.ashina.ecommerce.customer.infrastructure.persistence;

import org.ashina.ecommerce.customer.domain.Customer;

import java.util.Optional;

public interface CustomerPersistence {

    Optional<Customer> findByEmail(String email);

    void save(Customer user);
}
