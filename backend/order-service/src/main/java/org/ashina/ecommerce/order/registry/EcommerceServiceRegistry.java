package org.ashina.ecommerce.order.registry;

import org.ashina.ecommerce.order.infrastructure.ecommerce.CatalogService;
import org.ashina.ecommerce.order.infrastructure.ecommerce.InventoryService;
import org.ashina.ecommerce.order.infrastructure.ecommerce.feign.adapter.FeignCatalogService;
import org.ashina.ecommerce.order.infrastructure.ecommerce.feign.adapter.FeignInventoryService;
import org.ashina.ecommerce.order.infrastructure.ecommerce.feign.client.CatalogClient;
import org.ashina.ecommerce.order.infrastructure.ecommerce.feign.client.InventoryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Please comment @EnableFeignClients if you use other adapter
 */
@Configuration
@EnableFeignClients(basePackages = "org.ashina.ecommerce.order.infrastructure.ecommerce.feign.client")
public class EcommerceServiceRegistry {

    @Bean
    public CatalogService catalogService(CatalogClient catalogClient) {
        return new FeignCatalogService(catalogClient);
    }

    @Bean
    public InventoryService inventoryClient(InventoryClient inventoryClient) {
        return new FeignInventoryService(inventoryClient);
    }
}
