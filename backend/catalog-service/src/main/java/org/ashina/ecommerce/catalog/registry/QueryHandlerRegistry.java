package org.ashina.ecommerce.catalog.registry;

import org.ashina.ecommerce.catalog.application.query.handler.SearchProductQueryHandler;
import org.ashina.ecommerce.catalog.infrastructure.persistence.ProductPersistence;
import org.ashina.ecommerce.catalog.infrastructure.search.ProductSearch;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryHandlerRegistry {

    @Bean
    public SearchProductQueryHandler searchProductQueryHandler(ProductSearch productSearch,
                                                               ProductPersistence productPersistence) {
        return new SearchProductQueryHandler(productSearch, productPersistence);
    }
}
