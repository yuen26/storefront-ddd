package org.ashina.ecommerce.cart.application.command;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class DeleteCartLineCommand {

    @NotBlank
    private final String customerId;

    @NotBlank
    private final String productId;
}
