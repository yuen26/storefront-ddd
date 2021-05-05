package org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.adapter;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.inventory.domain.Supplier;
import org.ashina.ecommerce.inventory.infrastructure.persistence.SupplierPersistence;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.converter.JpaSupplierConverter;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.entity.JpaSupplier;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.repository.JpaSupplierRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaSupplierPersistence implements SupplierPersistence {

    private final JpaSupplierRepository jpaSupplierRepository;
    private final JpaSupplierConverter jpaSupplierConverter;

    @Override
    public Optional<Supplier> findById(String id) {
        return jpaSupplierRepository.findById(id)
                .map(jpaSupplierConverter::mapToDomainEntity);
    }

    @Override
    public void save(Supplier supplier) {
        JpaSupplier jpaSupplier = jpaSupplierConverter.mapToPersistentObject(supplier);
        jpaSupplierRepository.save(jpaSupplier);
    }
}
