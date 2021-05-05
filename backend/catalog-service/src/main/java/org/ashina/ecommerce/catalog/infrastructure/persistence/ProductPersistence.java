package org.ashina.ecommerce.catalog.infrastructure.persistence;

import org.ashina.ecommerce.catalog.domain.Product;

import java.util.Collection;
import java.util.List;

public interface ProductPersistence {

    List<Product> findByIdIn(Collection<String> ids);

    void save(Product product);
}
