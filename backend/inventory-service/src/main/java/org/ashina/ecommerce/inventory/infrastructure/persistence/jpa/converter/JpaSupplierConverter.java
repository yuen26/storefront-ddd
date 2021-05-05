package org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.converter;

import org.ashina.ecommerce.inventory.domain.Supplier;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.entity.JpaSupplier;
import org.ashina.ecommerce.sharedkernel.persistence.PersistenceConverter;

public class JpaSupplierConverter implements PersistenceConverter<Supplier, JpaSupplier> {

    @Override
    public JpaSupplier mapToPersistentObject(Supplier supplier) {
        JpaSupplier jpaSupplier = new JpaSupplier();
        jpaSupplier.setId(supplier.getId());
        jpaSupplier.setFullName(supplier.getFullName());
        jpaSupplier.setPhoneNumber(supplier.getPhoneNumber());
        return jpaSupplier;
    }

    @Override
    public Supplier mapToDomainEntity(JpaSupplier jpaSupplier) {
        Supplier supplier = new Supplier((jpaSupplier.getId()));
        supplier.setFullName(jpaSupplier.getFullName());
        supplier.setPhoneNumber(jpaSupplier.getPhoneNumber());
        return supplier;
    }
}
