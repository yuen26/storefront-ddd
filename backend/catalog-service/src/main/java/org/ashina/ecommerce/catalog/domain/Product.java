package org.ashina.ecommerce.catalog.domain;

import lombok.Getter;
import lombok.Setter;
import org.ashina.ecommerce.sharedkernel.domain.DomainAggregateRoot;

@Getter
@Setter
public class Product extends DomainAggregateRoot<String> {

    private String name;
    private String image;
    private Integer price;
    private String description;

    public Product(String id) {
        super(id);
    }
}
