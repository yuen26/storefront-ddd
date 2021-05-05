package org.ashina.ecommerce.customer.infrastructure.persistence.jpa.repository;

import org.ashina.ecommerce.customer.infrastructure.persistence.jpa.entity.JpaCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaCustomerRepository extends JpaRepository<JpaCustomer, String> {

    Optional<JpaCustomer> findByEmail(String email);
}
