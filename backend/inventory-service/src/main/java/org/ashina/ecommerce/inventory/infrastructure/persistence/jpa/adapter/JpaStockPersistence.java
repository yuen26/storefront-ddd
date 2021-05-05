package org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.adapter;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.inventory.domain.Stock;
import org.ashina.ecommerce.inventory.infrastructure.persistence.StockPersistence;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.converter.JpaStockConverter;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.entity.JpaStock;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.repository.JpaStockRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JpaStockPersistence implements StockPersistence {

    private final JpaStockRepository jpaStockRepository;
    private final JpaStockConverter jpaStockConverter;

    @Override
    public List<Stock> findByProductIdIn(Collection<String> productIds) {
        return jpaStockRepository.findByProductIdIn(productIds)
                .stream()
                .map(jpaStockConverter::mapToDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Stock> findByProductId(String id) {
        return jpaStockRepository.findById(id)
                .map(jpaStockConverter::mapToDomainEntity);
    }

    @Override
    public void save(Stock stock) {
        JpaStock jpaStock = jpaStockConverter.mapToPersistentObject(stock);
        jpaStockRepository.save(jpaStock);
    }

    @Override
    public void saveAll(List<Stock> stocks) {
        List<JpaStock> jpaStocks = stocks
                .stream()
                .map(jpaStockConverter::mapToPersistentObject)
                .collect(Collectors.toList());
        jpaStockRepository.saveAll(jpaStocks);
    }
}
