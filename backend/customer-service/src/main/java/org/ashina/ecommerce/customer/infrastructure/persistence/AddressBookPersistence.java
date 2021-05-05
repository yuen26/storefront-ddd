package org.ashina.ecommerce.customer.infrastructure.persistence;

import org.ashina.ecommerce.customer.domain.AddressBook;

import java.util.Optional;

public interface AddressBookPersistence {

    Optional<AddressBook> findByCustomerId(String customerId);

    void save(AddressBook addressBook);
}
