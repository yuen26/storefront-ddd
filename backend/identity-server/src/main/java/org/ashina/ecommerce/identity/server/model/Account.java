package org.ashina.ecommerce.identity.server.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account {

    @Id
    private String id;

    private String email;

    private String password;
}
