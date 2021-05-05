package org.ashina.ecommerce.inventory.registry;

import org.ashina.ecommerce.inventory.application.command.handler.CreatePurchaseCommandHandler;
import org.ashina.ecommerce.inventory.application.command.handler.CreateSupplierCommandHandler;
import org.ashina.ecommerce.inventory.application.command.handler.UpdateSupplierCommandHandler;
import org.ashina.ecommerce.inventory.infrastructure.ecommerce.CatalogService;
import org.ashina.ecommerce.inventory.infrastructure.persistence.PurchasePersistence;
import org.ashina.ecommerce.inventory.infrastructure.persistence.StockPersistence;
import org.ashina.ecommerce.inventory.infrastructure.persistence.SupplierPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandHandlerRegistry {

    @Bean
    public CreateSupplierCommandHandler createSupplierCommandHandler(SupplierPersistence supplierPersistence) {
        return new CreateSupplierCommandHandler(supplierPersistence);
    }

    @Bean
    public UpdateSupplierCommandHandler updateSupplierCommandHandler(SupplierPersistence supplierPersistence) {
        return new UpdateSupplierCommandHandler(supplierPersistence);
    }

    @Bean
    public CreatePurchaseCommandHandler createPurchaseCommandHandler(StockPersistence stockPersistence,
                                                                     SupplierPersistence supplierPersistence,
                                                                     PurchasePersistence purchasePersistence,
                                                                     CatalogService catalogService) {
        return new CreatePurchaseCommandHandler(
                stockPersistence,
                supplierPersistence,
                purchasePersistence,
                catalogService);
    }
}
