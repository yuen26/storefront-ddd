package org.ashina.ecommerce.inventory.registry;

import org.ashina.ecommerce.inventory.application.query.handler.GetStocksQueryHandler;
import org.ashina.ecommerce.inventory.infrastructure.persistence.StockPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryHandlerRegistry {

    @Bean
    public GetStocksQueryHandler getStocksQueryHandler(StockPersistence stockPersistence) {
        return new GetStocksQueryHandler(stockPersistence);
    }
}
