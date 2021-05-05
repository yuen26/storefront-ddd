package org.ashina.ecommerce.inventory.infrastructure.ecommerce.feign.adapter;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.inventory.infrastructure.ecommerce.CatalogService;
import org.ashina.ecommerce.inventory.infrastructure.ecommerce.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class FeignCatalogService implements CatalogService {

    private final org.ashina.ecommerce.inventory.infrastructure.ecommerce.feign.client.CatalogClient catalogClient;

    @Override
    public Optional<Product> getProduct(String id) {
        List<Product> products = catalogClient.getProducts(Collections.singleton(id));
        return products
                .stream()
                .filter(product -> product.getId().equals(id))
                .findAny();
    }
}
