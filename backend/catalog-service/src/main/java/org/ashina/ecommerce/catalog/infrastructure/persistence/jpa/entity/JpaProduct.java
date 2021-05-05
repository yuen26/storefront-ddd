package org.ashina.ecommerce.catalog.infrastructure.persistence.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Getter
@Setter
public class JpaProduct extends JpaBaseEntity {

    @Id
    private String id;

    private String name;

    private String image;

    private Integer price;

    private String description;
}
