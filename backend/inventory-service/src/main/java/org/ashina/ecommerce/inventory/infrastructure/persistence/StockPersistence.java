package org.ashina.ecommerce.inventory.infrastructure.persistence;

import org.ashina.ecommerce.inventory.domain.Stock;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StockPersistence {

    List<Stock> findByProductIdIn(Collection<String> productIds);

    Optional<Stock> findByProductId(String productId);

    void save(Stock stock);

    void saveAll(List<Stock> stocks);
}
