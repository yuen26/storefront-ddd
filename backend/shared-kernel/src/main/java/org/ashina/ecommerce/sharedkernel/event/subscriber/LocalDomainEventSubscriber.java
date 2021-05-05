package org.ashina.ecommerce.sharedkernel.event.subscriber;

import org.ashina.ecommerce.sharedkernel.event.model.DomainEvent;

public interface LocalDomainEventSubscriber<T extends DomainEvent> {

    void subscribe(T event);

}
