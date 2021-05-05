package org.ashina.ecommerce.order.infrastructure.ecommerce;

import org.ashina.ecommerce.order.infrastructure.ecommerce.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CatalogService {

    Map<String, Product> getProducts(List<String> ids);

    Optional<Product> getProduct(String id);

}
