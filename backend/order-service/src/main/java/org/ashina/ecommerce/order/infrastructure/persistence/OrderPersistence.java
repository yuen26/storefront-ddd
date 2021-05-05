package org.ashina.ecommerce.order.infrastructure.persistence;

import org.ashina.ecommerce.order.domain.Order;

import java.util.Optional;

public interface OrderPersistence {

    Optional<Order> findById(String id);

    void save(Order order);
}
