package org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.repository;

import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.entity.JpaSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSupplierRepository extends JpaRepository<JpaSupplier, String> {
}
