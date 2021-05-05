package org.ashina.ecommerce.customer.application.rest.dto;

import lombok.Data;
import org.ashina.ecommerce.sharedkernel.security.Roles;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class CreateCustomerDto {

    @NotBlank
    @Size(max = 100)
    private String fullName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 50)
    private String password;

    @NotEmpty
    private Set<Roles> roles;
}
