package org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.converter;

import org.ashina.ecommerce.inventory.domain.Stock;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.entity.JpaStock;
import org.ashina.ecommerce.sharedkernel.persistence.PersistenceConverter;

public class JpaStockConverter implements PersistenceConverter<Stock, JpaStock> {

    @Override
    public JpaStock mapToPersistentObject(Stock stock) {
        JpaStock jpaStock = new JpaStock();
        jpaStock.setProductId(stock.getProductId());
        jpaStock.setQuantity(stock.getQuantity());
        return jpaStock;
    }

    @Override
    public Stock mapToDomainEntity(JpaStock jpaStock) {
        Stock stock = new Stock((jpaStock.getProductId()));
        stock.setQuantity(jpaStock.getQuantity());
        return stock;
    }
}
