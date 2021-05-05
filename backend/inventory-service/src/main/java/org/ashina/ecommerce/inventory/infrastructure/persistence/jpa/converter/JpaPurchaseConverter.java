package org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.converter;

import org.ashina.ecommerce.inventory.domain.Purchase;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.entity.JpaPurchase;
import org.ashina.ecommerce.sharedkernel.persistence.PersistenceConverter;

public class JpaPurchaseConverter implements PersistenceConverter<Purchase, JpaPurchase> {

    @Override
    public JpaPurchase mapToPersistentObject(Purchase purchase) {
        JpaPurchase jpaPurchase = new JpaPurchase();
        jpaPurchase.setId(purchase.getId());
        jpaPurchase.setSupplierId(purchase.getSupplierId());
        jpaPurchase.setProductId(purchase.getProductId());
        jpaPurchase.setQuantity(purchase.getQuantity());
        return jpaPurchase;
    }

    @Override
    public Purchase mapToDomainEntity(JpaPurchase jpaPurchase) {
        Purchase purchase = new Purchase((jpaPurchase.getId()));
        purchase.setSupplierId(jpaPurchase.getSupplierId());
        purchase.setProductId(jpaPurchase.getProductId());
        purchase.setQuantity(jpaPurchase.getQuantity());
        return purchase;
    }
}
