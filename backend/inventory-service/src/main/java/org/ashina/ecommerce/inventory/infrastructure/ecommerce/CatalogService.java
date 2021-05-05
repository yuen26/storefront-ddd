package org.ashina.ecommerce.inventory.infrastructure.ecommerce;

import org.ashina.ecommerce.inventory.infrastructure.ecommerce.model.Product;

import java.util.Optional;

public interface CatalogService {

    Optional<Product> getProduct(String id);

}
