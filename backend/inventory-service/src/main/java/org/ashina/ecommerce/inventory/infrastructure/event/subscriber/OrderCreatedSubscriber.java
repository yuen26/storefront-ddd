package org.ashina.ecommerce.inventory.infrastructure.event.subscriber;

import org.ashina.ecommerce.sharedkernel.event.model.order.OrderCreated;
import org.ashina.ecommerce.sharedkernel.event.subscriber.RemoteDomainEventSubscriber;

public interface OrderCreatedSubscriber extends RemoteDomainEventSubscriber<OrderCreated> {
}
