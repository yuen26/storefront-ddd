package org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchases")
@Getter
@Setter
public class JpaPurchase extends JpaBaseEntity {

    @Id
    private String id;

    private String supplierId;

    private String productId;

    private Integer quantity;
}
