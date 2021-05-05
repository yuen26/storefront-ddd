package org.ashina.ecommerce.order.registry;

import org.ashina.ecommerce.order.application.query.handler.GetCartQueryHandler;
import org.ashina.ecommerce.order.infrastructure.ecommerce.CatalogService;
import org.ashina.ecommerce.order.infrastructure.persistence.CartLinePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryHandlerRegistry {

    @Bean
    public GetCartQueryHandler getCartQueryHandler(CartLinePersistence cartLinePersistence,
                                                   CatalogService catalogService) {
        return new GetCartQueryHandler(cartLinePersistence, catalogService);
    }
}
