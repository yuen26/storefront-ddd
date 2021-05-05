package org.ashina.ecommerce.inventory.application.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CreateSupplierDto {

    @NotBlank
    @Size(max = 255)
    private String fullName;

    @NotBlank
    @Pattern(regexp = "[0-9]{10,20}")
    private String phoneNumber;
}
