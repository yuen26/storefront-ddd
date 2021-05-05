package org.ashina.ecommerce.inventory.registry;

import org.ashina.ecommerce.inventory.infrastructure.persistence.PurchasePersistence;
import org.ashina.ecommerce.inventory.infrastructure.persistence.StockPersistence;
import org.ashina.ecommerce.inventory.infrastructure.persistence.SupplierPersistence;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.adapter.JpaPurchasePersistence;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.adapter.JpaStockPersistence;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.adapter.JpaSupplierPersistence;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.converter.JpaPurchaseConverter;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.converter.JpaStockConverter;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.converter.JpaSupplierConverter;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.repository.JpaPurchaseRepository;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.repository.JpaStockRepository;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.repository.JpaSupplierRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceRegistry {

    @Bean
    public JpaStockConverter jpaStockConverter() {
        return new JpaStockConverter();
    }

    @Bean
    public StockPersistence stockPersistence(JpaStockRepository jpaStockRepository,
                                             JpaStockConverter jpaStockConverter) {
        return new JpaStockPersistence(jpaStockRepository, jpaStockConverter);
    }

    @Bean
    public JpaSupplierConverter jpaSupplierConverter() {
        return new JpaSupplierConverter();
    }

    @Bean
    public SupplierPersistence supplierPersistence(JpaSupplierRepository jpaSupplierRepository,
                                                   JpaSupplierConverter jpaSupplierConverter) {
        return new JpaSupplierPersistence(jpaSupplierRepository, jpaSupplierConverter);
    }

    @Bean
    public JpaPurchaseConverter jpaPurchaseConverter() {
        return new JpaPurchaseConverter();
    }

    @Bean
    public PurchasePersistence purchasePersistence(JpaPurchaseRepository jpaPurchaseRepository,
                                                   JpaPurchaseConverter jpaPurchaseConverter) {
        return new JpaPurchasePersistence(jpaPurchaseRepository, jpaPurchaseConverter);
    }
}
