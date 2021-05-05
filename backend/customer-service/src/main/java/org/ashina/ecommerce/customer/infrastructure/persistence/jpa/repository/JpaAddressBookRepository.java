package org.ashina.ecommerce.customer.infrastructure.persistence.jpa.repository;

import org.ashina.ecommerce.customer.infrastructure.persistence.jpa.entity.JpaAddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAddressBookRepository extends JpaRepository<JpaAddressBook, String> {
}
