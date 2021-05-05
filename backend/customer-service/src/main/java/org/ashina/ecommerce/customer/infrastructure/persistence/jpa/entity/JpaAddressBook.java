package org.ashina.ecommerce.customer.infrastructure.persistence.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address_books")
@Getter
@Setter
public class JpaAddressBook extends JpaBaseEntity {

    @Id
    private String id;

    private String fullName;

    private String phoneNumber;

    private String address;
}
