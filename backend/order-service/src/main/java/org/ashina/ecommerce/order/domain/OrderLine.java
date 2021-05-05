package org.ashina.ecommerce.order.domain;

import lombok.Getter;
import lombok.Setter;
import org.ashina.ecommerce.sharedkernel.domain.DomainValueObject;

@Getter
@Setter
public class OrderLine extends DomainValueObject {

    private String productId;
    private Integer productPrice;
    private Integer quantity;
}
