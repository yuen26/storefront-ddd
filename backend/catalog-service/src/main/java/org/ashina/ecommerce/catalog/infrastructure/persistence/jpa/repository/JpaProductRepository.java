package org.ashina.ecommerce.catalog.infrastructure.persistence.jpa.repository;

import org.ashina.ecommerce.catalog.infrastructure.persistence.jpa.entity.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<JpaProduct, String> {
}
