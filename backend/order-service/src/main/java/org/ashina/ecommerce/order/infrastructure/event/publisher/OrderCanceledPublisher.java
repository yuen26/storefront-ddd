package org.ashina.ecommerce.order.infrastructure.event.publisher;

import org.ashina.ecommerce.sharedkernel.event.model.order.OrderCanceled;
import org.ashina.ecommerce.sharedkernel.event.publisher.RemoteDomainEventPublisher;

public interface OrderCanceledPublisher extends RemoteDomainEventPublisher<OrderCanceled> {
}
