package org.ashina.ecommerce.catalog.registry;

import org.ashina.ecommerce.catalog.infrastructure.search.ProductSearch;
import org.ashina.ecommerce.catalog.infrastructure.search.elasticsearch.adapter.EsProductSearch;
import org.ashina.ecommerce.catalog.infrastructure.search.elasticsearch.repository.EsProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SearchRegistry {

    @Bean
    public ProductSearch productSearch(EsProductRepository elasticsearchProductRepository) {
        return new EsProductSearch(elasticsearchProductRepository);
    }
}
