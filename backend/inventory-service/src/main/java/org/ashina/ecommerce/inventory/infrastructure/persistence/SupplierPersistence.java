package org.ashina.ecommerce.inventory.infrastructure.persistence;

import org.ashina.ecommerce.inventory.domain.Supplier;

import java.util.Optional;

public interface SupplierPersistence {

    Optional<Supplier> findById(String id);

    void save(Supplier supplier);
}
