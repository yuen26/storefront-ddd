package org.ashina.ecommerce.order.infrastructure.persistence.jpa.converter;

import org.ashina.ecommerce.order.domain.OrderLine;
import org.ashina.ecommerce.order.infrastructure.persistence.jpa.entity.JpaOrderLine;
import org.ashina.ecommerce.sharedkernel.domain.DomainEntityIdentifierGenerator;
import org.ashina.ecommerce.sharedkernel.persistence.PersistenceConverter;

public class JpaOrderLineConverter implements PersistenceConverter<OrderLine, JpaOrderLine> {

    @Override
    public JpaOrderLine mapToPersistentObject(OrderLine orderLine) {
        JpaOrderLine jpaOrderLine = new JpaOrderLine();
        jpaOrderLine.setId(DomainEntityIdentifierGenerator.uuid());
        jpaOrderLine.setProductId(orderLine.getProductId());
        jpaOrderLine.setProductPrice(orderLine.getProductPrice());
        jpaOrderLine.setQuantity(orderLine.getQuantity());
        return jpaOrderLine;
    }

    @Override
    public OrderLine mapToDomainEntity(JpaOrderLine jpaOrderLine) {
        OrderLine orderLine = new OrderLine();
        orderLine.setProductId(jpaOrderLine.getProductId());
        orderLine.setProductPrice(jpaOrderLine.getProductPrice());
        orderLine.setQuantity(jpaOrderLine.getQuantity());
        return orderLine;
    }
}
