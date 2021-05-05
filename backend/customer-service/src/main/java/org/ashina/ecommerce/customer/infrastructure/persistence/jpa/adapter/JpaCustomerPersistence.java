package org.ashina.ecommerce.customer.infrastructure.persistence.jpa.adapter;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.customer.domain.Customer;
import org.ashina.ecommerce.customer.infrastructure.persistence.CustomerPersistence;
import org.ashina.ecommerce.customer.infrastructure.persistence.jpa.converter.JpaCustomerConverter;
import org.ashina.ecommerce.customer.infrastructure.persistence.jpa.entity.JpaCustomer;
import org.ashina.ecommerce.customer.infrastructure.persistence.jpa.repository.JpaCustomerRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaCustomerPersistence implements CustomerPersistence {

    private final JpaCustomerRepository jpaCustomerRepository;
    private final JpaCustomerConverter jpaCustomerConverter;

    @Override
    public Optional<Customer> findByEmail(String email) {
        return jpaCustomerRepository.findByEmail(email)
                .map(jpaCustomerConverter::mapToDomainEntity);
    }

    @Override
    public void save(Customer customer) {
        JpaCustomer jpaCustomer = jpaCustomerConverter.mapToPersistentObject(customer);
        jpaCustomerRepository.save(jpaCustomer);
    }
}
