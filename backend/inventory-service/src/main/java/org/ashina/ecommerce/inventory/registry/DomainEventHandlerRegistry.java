package org.ashina.ecommerce.inventory.registry;

import org.ashina.ecommerce.inventory.application.event.handler.OrderCanceledHandler;
import org.ashina.ecommerce.inventory.infrastructure.persistence.StockPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainEventHandlerRegistry {

    @Bean
    public OrderCanceledHandler orderCanceledHandler(StockPersistence stockPersistence) {
        return new OrderCanceledHandler(stockPersistence);
    }
}
