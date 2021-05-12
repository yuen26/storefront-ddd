package org.ashina.ecommerce.customer.infrastructure.identity.internal.model;

import lombok.Data;
import org.ashina.ecommerce.customer.domain.Customer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class CreateAccountRequest {

    private String id;

    private String email;

    private String password;

    private boolean admin;

    public CreateAccountRequest(Customer customer, String password) {
        this.id = customer.getId();
        this.email = customer.getEmail();
        this.password = password;
        this.admin = false;
    }
}
