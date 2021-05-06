package org.ashina.ecommerce.catalog.registry;

import org.ashina.ecommerce.catalog.application.command.handler.CreateProductCommandHandler;
import org.ashina.ecommerce.catalog.infrastructure.persistence.ProductPersistence;
import org.ashina.ecommerce.catalog.infrastructure.search.ProductSearch;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandHandlerRegistry {

    @Bean
    public CreateProductCommandHandler createProductCommandHandler(ProductPersistence productPersistence,
                                                                   ProductSearch productSearch) {
        return new CreateProductCommandHandler(productPersistence, productSearch);
    }
}
