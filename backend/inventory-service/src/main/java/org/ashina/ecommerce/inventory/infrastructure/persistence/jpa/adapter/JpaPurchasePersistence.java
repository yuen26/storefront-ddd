package org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.adapter;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.inventory.domain.Purchase;
import org.ashina.ecommerce.inventory.infrastructure.persistence.PurchasePersistence;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.converter.JpaPurchaseConverter;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.entity.JpaPurchase;
import org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.repository.JpaPurchaseRepository;

@RequiredArgsConstructor
public class JpaPurchasePersistence implements PurchasePersistence {

    private final JpaPurchaseRepository jpaPurchaseRepository;
    private final JpaPurchaseConverter jpaPurchaseConverter;

    @Override
    public void save(Purchase purchase) {
        JpaPurchase jpaPurchase = jpaPurchaseConverter.mapToPersistentObject(purchase);
        jpaPurchaseRepository.save(jpaPurchase);
    }
}
