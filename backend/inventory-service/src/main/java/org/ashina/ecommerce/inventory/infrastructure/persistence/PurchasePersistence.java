package org.ashina.ecommerce.inventory.infrastructure.persistence;

import org.ashina.ecommerce.inventory.domain.Purchase;

public interface PurchasePersistence {

    void save(Purchase purchase);
}
