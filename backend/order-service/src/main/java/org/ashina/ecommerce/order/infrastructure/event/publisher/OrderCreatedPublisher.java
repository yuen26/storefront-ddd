package org.ashina.ecommerce.order.infrastructure.event.publisher;

import org.ashina.ecommerce.sharedkernel.event.model.order.OrderCreated;
import org.ashina.ecommerce.sharedkernel.event.publisher.RemoteDomainEventPublisher;

public interface OrderCreatedPublisher extends RemoteDomainEventPublisher<OrderCreated> {
}
