package org.ashina.ecommerce.customer.domain;

import lombok.Getter;
import lombok.Setter;
import org.ashina.ecommerce.sharedkernel.domain.DomainAggregateRoot;

@Getter
@Setter
public class AddressBook extends DomainAggregateRoot<String> {

    private String fullName;
    private String phoneNumber;
    private String address;

    public AddressBook(String customerId) {
        super(customerId);
    }
}
