package org.ashina.ecommerce.inventory.application.command.model;

import lombok.Data;
import org.ashina.ecommerce.sharedkernel.command.model.Command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UpdateSupplierCommand extends Command {

    @NotBlank
    private String id;

    @NotBlank
    @Size(max = 255)
    private String fullName;

    @NotBlank
    @Pattern(regexp = "[0-9]{10,20}")
    private String phoneNumber;
}
