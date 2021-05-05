package org.ashina.ecommerce.order.application.rest.controller;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.order.application.command.CancelOrderCommand;
import org.ashina.ecommerce.order.application.command.CreateOrderCommand;
import org.ashina.ecommerce.sharedkernel.command.gateway.CommandGateway;
import org.ashina.ecommerce.sharedkernel.security.SecurityContextHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final CommandGateway commandGateway;

    @PostMapping("/api/v1/orders")
    public ResponseEntity<Void> createOrder() throws Exception {
        CreateOrderCommand command = newCreateOrderCommand();
        commandGateway.send(command);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private CreateOrderCommand newCreateOrderCommand() {
        CreateOrderCommand command = new CreateOrderCommand();
        command.setCustomerId(SecurityContextHelper.currentCustomerId());
        return command;
    }

    @PostMapping("/api/v1/orders/{orderId}/cancel")
    public ResponseEntity<Void> cancelOrder(@PathVariable String orderId) throws Exception {
        CancelOrderCommand command = newCancelOrderCommand(orderId);
        commandGateway.send(command);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private CancelOrderCommand newCancelOrderCommand(String orderId) {
        CancelOrderCommand command = new CancelOrderCommand();
        command.setCustomerId(SecurityContextHelper.currentCustomerId());
        command.setOrderId(orderId);
        return command;
    }

}
