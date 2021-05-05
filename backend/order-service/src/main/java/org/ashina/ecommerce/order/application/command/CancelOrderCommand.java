package org.ashina.ecommerce.order.application.command;

import lombok.Data;
import org.ashina.ecommerce.sharedkernel.command.model.Command;

import javax.validation.constraints.NotBlank;

@Data
public class CancelOrderCommand extends Command {

    @NotBlank
    private String customerId;

    @NotBlank
    private String orderId;
}