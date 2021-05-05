package org.ashina.ecommerce.order.infrastructure.event.publisher.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderCreatedSource {

    String OUTPUT = "order-created-out";

    @Output(OrderCreatedSource.OUTPUT)
    MessageChannel output();
}
