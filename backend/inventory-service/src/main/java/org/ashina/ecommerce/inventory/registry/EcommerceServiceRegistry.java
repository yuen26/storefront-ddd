package org.ashina.ecommerce.inventory.registry;

import org.ashina.ecommerce.inventory.infrastructure.ecommerce.CatalogService;
import org.ashina.ecommerce.inventory.infrastructure.ecommerce.feign.adapter.FeignCatalogService;
import org.ashina.ecommerce.inventory.infrastructure.ecommerce.feign.client.CatalogClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Please comment @EnableFeignClients if you use other adapter
 */
@Configuration
@EnableFeignClients(basePackages = "org.ashina.ecommerce.inventory.infrastructure.ecommerce.feign.client")
public class EcommerceServiceRegistry {

    @Bean
    public CatalogService catalogService(CatalogClient catalogClient) {
        return new FeignCatalogService(catalogClient);
    }
}
