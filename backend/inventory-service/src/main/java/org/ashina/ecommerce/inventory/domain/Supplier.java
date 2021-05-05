package org.ashina.ecommerce.inventory.domain;

import lombok.Getter;
import lombok.Setter;
import org.ashina.ecommerce.sharedkernel.domain.DomainAggregateRoot;

@Getter
@Setter
public class Supplier extends DomainAggregateRoot<String> {

    private String fullName;
    private String phoneNumber;

    public Supplier(String id) {
        super(id);
    }
}
