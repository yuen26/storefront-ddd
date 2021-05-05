package org.ashina.ecommerce.inventory.domain;

import lombok.Getter;
import lombok.Setter;
import org.ashina.ecommerce.sharedkernel.domain.DomainAggregateRoot;

@Getter
@Setter
public class Purchase extends DomainAggregateRoot<String> {

    private String supplierId;
    private String productId;
    private Integer quantity;

    public Purchase(String id) {
        super(id);
    }
}
