package org.ashina.ecommerce.customer.infrastructure.persistence.jpa.converter;

import org.ashina.ecommerce.customer.domain.Customer;
import org.ashina.ecommerce.customer.infrastructure.persistence.jpa.entity.JpaCustomer;
import org.ashina.ecommerce.sharedkernel.persistence.PersistenceConverter;

public class JpaCustomerConverter implements PersistenceConverter<Customer, JpaCustomer> {

    @Override
    public JpaCustomer mapToPersistentObject(Customer customer) {
        JpaCustomer jpaCustomer = new JpaCustomer();
        jpaCustomer.setId(customer.getId());
        jpaCustomer.setFullName(customer.getFullName());
        jpaCustomer.setEmail(customer.getEmail());
        return jpaCustomer;
    }

    @Override
    public Customer mapToDomainEntity(JpaCustomer jpaCustomer) {
        Customer customer = new Customer((jpaCustomer.getId()));
        customer.setFullName(jpaCustomer.getFullName());
        customer.setEmail(jpaCustomer.getEmail());
        return customer;
    }
}
