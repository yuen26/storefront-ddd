package org.ashina.ecommerce.order.infrastructure.persistence.jpa.adapter;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.order.domain.Order;
import org.ashina.ecommerce.order.infrastructure.persistence.OrderPersistence;
import org.ashina.ecommerce.order.infrastructure.persistence.jpa.converter.JpaOrderConverter;
import org.ashina.ecommerce.order.infrastructure.persistence.jpa.entity.JpaOrder;
import org.ashina.ecommerce.order.infrastructure.persistence.jpa.repository.JpaOrderRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaOrderPersistence implements OrderPersistence {

    private final JpaOrderRepository jpaOrderRepository;
    private final JpaOrderConverter jpaOrderConverter;

    @Override
    public Optional<Order> findById(String id) {
        return jpaOrderRepository.findById(id)
                .map(jpaOrderConverter::mapToDomainEntity);
    }

    @Override
    public void save(Order order) {
        JpaOrder jpaOrder = jpaOrderConverter.mapToPersistentObject(order);
        jpaOrderRepository.save(jpaOrder);
    }
}
