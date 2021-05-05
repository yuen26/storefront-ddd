package org.ashina.ecommerce.inventory.infrastructure.event.subscriber.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface OrderCreatedSink {

    String INPUT = "order-created-in";

    @Input(OrderCreatedSink.INPUT)
    SubscribableChannel input();
}
