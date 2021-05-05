package org.ashina.ecommerce.catalog.registry;

import org.ashina.ecommerce.catalog.infrastructure.persistence.ProductPersistence;
import org.ashina.ecommerce.catalog.infrastructure.persistence.jpa.adapter.JpaProductPersistence;
import org.ashina.ecommerce.catalog.infrastructure.persistence.jpa.converter.JpaProductConverter;
import org.ashina.ecommerce.catalog.infrastructure.persistence.jpa.repository.JpaProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceRegistry {

    @Bean
    public JpaProductConverter jpaProductConverter() {
        return new JpaProductConverter();
    }

    @Bean
    public ProductPersistence productPersistence(JpaProductRepository jpaProductRepository,
                                                 JpaProductConverter jpaProductConverter) {
        return new JpaProductPersistence(jpaProductRepository, jpaProductConverter);
    }

}
