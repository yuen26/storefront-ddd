package org.ashina.ecommerce.catalog.infrastructure.persistence.jpa.converter;

import org.ashina.ecommerce.catalog.domain.Product;
import org.ashina.ecommerce.catalog.infrastructure.persistence.jpa.entity.JpaProduct;
import org.ashina.ecommerce.sharedkernel.persistence.PersistenceConverter;

public class JpaProductConverter implements PersistenceConverter<Product, JpaProduct> {

    @Override
    public JpaProduct mapToPersistentObject(Product product) {
        JpaProduct jpaProduct = new JpaProduct();
        jpaProduct.setId(product.getId());
        jpaProduct.setName(product.getName());
        jpaProduct.setImage(product.getImage());
        jpaProduct.setPrice(product.getPrice());
        jpaProduct.setDescription(product.getDescription());
        return jpaProduct;
    }

    @Override
    public Product mapToDomainEntity(JpaProduct jpaProduct) {
        Product product = new Product((jpaProduct.getId()));
        product.setName(jpaProduct.getName());
        product.setImage(jpaProduct.getImage());
        product.setPrice(jpaProduct.getPrice());
        product.setDescription(jpaProduct.getDescription());
        return product;
    }
}
