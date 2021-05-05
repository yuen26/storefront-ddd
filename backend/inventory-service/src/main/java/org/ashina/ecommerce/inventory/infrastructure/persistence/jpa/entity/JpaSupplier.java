package org.ashina.ecommerce.inventory.infrastructure.persistence.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "suppliers")
@Getter
@Setter
public class JpaSupplier extends JpaBaseEntity {

    @Id
    private String id;

    private String fullName;

    private String phoneNumber;
}
