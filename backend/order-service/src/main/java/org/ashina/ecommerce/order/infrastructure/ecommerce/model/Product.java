package org.ashina.ecommerce.order.infrastructure.ecommerce.model;

import lombok.Data;

@Data
public class Product {

    private String id;
    private String name;
    private String image;
    private Integer price;
}
