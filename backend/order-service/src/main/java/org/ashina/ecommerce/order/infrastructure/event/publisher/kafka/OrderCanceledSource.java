package org.ashina.ecommerce.order.infrastructure.event.publisher.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderCanceledSource {

    String OUTPUT = "order-canceled-out";

    @Output(OrderCanceledSource.OUTPUT)
    MessageChannel output();
}
