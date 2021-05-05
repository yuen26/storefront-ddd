package org.ashina.ecommerce.inventory.registry;

import org.ashina.ecommerce.inventory.application.event.handler.OrderCanceledHandler;
import org.ashina.ecommerce.inventory.application.event.handler.OrderCreatedHandler;
import org.ashina.ecommerce.inventory.infrastructure.event.subscriber.OrderCanceledSubscriber;
import org.ashina.ecommerce.inventory.infrastructure.event.subscriber.OrderCreatedSubscriber;
import org.ashina.ecommerce.inventory.infrastructure.event.subscriber.kafka.KafkaOrderCanceledSubscriber;
import org.ashina.ecommerce.inventory.infrastructure.event.subscriber.kafka.KafkaOrderCreatedSubscriber;
import org.ashina.ecommerce.inventory.infrastructure.event.subscriber.kafka.OrderCanceledSink;
import org.ashina.ecommerce.inventory.infrastructure.event.subscriber.kafka.OrderCreatedSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({OrderCreatedSink.class, OrderCanceledSink.class})
public class DomainEventSubscriberRegistry {

    @Bean
    public OrderCreatedSubscriber orderCreatedSubscriber(OrderCreatedHandler orderCreatedHandler) {
        return new KafkaOrderCreatedSubscriber(orderCreatedHandler);
    }

    @Bean
    public OrderCanceledSubscriber orderCanceledSubscriber(OrderCanceledHandler orderCanceledHandler) {
        return new KafkaOrderCanceledSubscriber(orderCanceledHandler);
    }
}
