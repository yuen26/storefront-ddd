package org.ashina.ecommerce.customer.application.query.model;

import lombok.Data;
import org.ashina.ecommerce.sharedkernel.query.model.Query;

@Data
public class GetAddressBookQuery extends Query {

    private String customerId;
}
