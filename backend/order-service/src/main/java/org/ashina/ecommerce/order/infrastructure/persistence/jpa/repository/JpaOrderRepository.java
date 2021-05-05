package org.ashina.ecommerce.order.infrastructure.persistence.jpa.repository;

import org.ashina.ecommerce.order.infrastructure.persistence.jpa.entity.JpaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderRepository extends JpaRepository<JpaOrder, String> {
}
