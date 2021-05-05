package org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
@Getter
@Setter
public class JpaStock extends JpaBaseEntity {

    @Id
    private String productId;

    private Integer quantity;
}
