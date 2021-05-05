package org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.repository;

import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.entity.JpaPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPurchaseRepository extends JpaRepository<JpaPurchase, String> {
}
