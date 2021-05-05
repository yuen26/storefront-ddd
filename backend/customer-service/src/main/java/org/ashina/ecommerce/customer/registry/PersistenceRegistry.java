package org.ashina.ecommerce.customer.registry;

import org.ashina.ecommerce.customer.infrastructure.persistence.AddressBookPersistence;
import org.ashina.ecommerce.customer.infrastructure.persistence.CustomerPersistence;
import org.ashina.ecommerce.customer.infrastructure.persistence.jpa.adapter.JpaAddressBookBookPersistence;
import org.ashina.ecommerce.customer.infrastructure.persistence.jpa.adapter.JpaCustomerPersistence;
import org.ashina.ecommerce.customer.infrastructure.persistence.jpa.converter.JpaAddressBookConverter;
import org.ashina.ecommerce.customer.infrastructure.persistence.jpa.converter.JpaCustomerConverter;
import org.ashina.ecommerce.customer.infrastructure.persistence.jpa.repository.JpaAddressBookRepository;
import org.ashina.ecommerce.customer.infrastructure.persistence.jpa.repository.JpaCustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceRegistry {

    @Bean
    public JpaCustomerConverter jpaCustomerConverter() {
        return new JpaCustomerConverter();
    }

    @Bean
    public CustomerPersistence customerPersistence(JpaCustomerRepository jpaCustomerRepository,
                                                   JpaCustomerConverter jpaCustomerConverter) {
        return new JpaCustomerPersistence(jpaCustomerRepository, jpaCustomerConverter);
    }

    @Bean
    public JpaAddressBookConverter jpaAddressConverter() {
        return new JpaAddressBookConverter();
    }

    @Bean
    public AddressBookPersistence addressBookPersistence(JpaAddressBookRepository jpaAddressBookRepository,
                                                         JpaAddressBookConverter jpaAddressBookConverter) {
        return new JpaAddressBookBookPersistence(jpaAddressBookRepository, jpaAddressBookConverter);
    }

}
