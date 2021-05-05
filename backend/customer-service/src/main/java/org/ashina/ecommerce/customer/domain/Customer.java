package org.ashina.ecommerce.customer.domain;

import lombok.Getter;
import lombok.Setter;
import org.ashina.ecommerce.sharedkernel.domain.DomainAggregateRoot;

@Getter
@Setter
public class Customer extends DomainAggregateRoot<String> {

    private String fullName;
    private String email;

    public Customer(String id) {
        super(id);
    }
}
