package org.ashina.ecommerce.customer.application.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CreateAddressBookDto {

    @NotBlank
    @Size(max = 100)
    private String fullName;

    @NotBlank
    @Pattern(regexp = "[0-9]{10,20}")
    private String phoneNumber;

    @NotBlank
    private String address;
}
