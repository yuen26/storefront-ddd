package org.ashina.ecommerce.sharedkernel.event.publisher;

import org.ashina.ecommerce.sharedkernel.event.model.DomainEvent;

public interface LocalDomainEventPublisher<T extends DomainEvent> {

    void publish(T event);

}
