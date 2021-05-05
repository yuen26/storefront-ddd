package org.ashina.ecommerce.inventory.domain;

import lombok.Getter;
import lombok.Setter;
import org.ashina.ecommerce.sharedkernel.domain.DomainAggregateRoot;

@Getter
@Setter
public class Stock extends DomainAggregateRoot<String> {

    private String productId;
    private Integer quantity;

    public Stock(String id) {
        super(id);
    }
}
