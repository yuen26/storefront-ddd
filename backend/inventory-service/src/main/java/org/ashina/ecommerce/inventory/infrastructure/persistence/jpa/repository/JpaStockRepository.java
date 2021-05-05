package org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.repository;

import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.entity.JpaStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface JpaStockRepository extends JpaRepository<JpaStock, String> {

    List<JpaStock> findByProductIdIn(Collection<String> productIds);
}
