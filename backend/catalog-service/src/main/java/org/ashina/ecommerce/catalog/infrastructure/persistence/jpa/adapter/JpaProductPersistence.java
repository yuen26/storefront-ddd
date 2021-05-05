package org.ashina.ecommerce.catalog.infrastructure.persistence.jpa.adapter;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.catalog.domain.Product;
import org.ashina.ecommerce.catalog.infrastructure.persistence.ProductPersistence;
import org.ashina.ecommerce.catalog.infrastructure.persistence.jpa.converter.JpaProductConverter;
import org.ashina.ecommerce.catalog.infrastructure.persistence.jpa.entity.JpaProduct;
import org.ashina.ecommerce.catalog.infrastructure.persistence.jpa.repository.JpaProductRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JpaProductPersistence implements ProductPersistence {

    private final JpaProductRepository jpaProductRepository;
    private final JpaProductConverter jpaProductConverter;

    @Override
    public List<Product> findByIdIn(Collection<String> ids) {
        return jpaProductRepository.findAllById(ids)
                .stream()
                .map(jpaProductConverter::mapToDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Product product) {
        JpaProduct jpaProduct = jpaProductConverter.mapToPersistentObject(product);
        jpaProductRepository.save(jpaProduct);
    }
}
