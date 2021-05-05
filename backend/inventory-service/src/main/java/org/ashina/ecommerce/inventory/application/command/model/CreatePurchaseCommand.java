package org.ashina.ecommerce.inventory.application.command.model;

import lombok.Data;
import org.ashina.ecommerce.sharedkernel.command.model.Command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CreatePurchaseCommand extends Command {

    @NotBlank
    private String supplierId;

    @NotBlank
    private String productId;

    @NotNull
    @Positive
    private Integer quantity;
}
