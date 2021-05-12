package org.ashina.ecommerce.customer.application.rest.controller;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.customer.application.command.model.CreateCustomerCommand;
import org.ashina.ecommerce.customer.application.rest.dto.CreateCustomerDto;
import org.ashina.ecommerce.sharedkernel.command.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CommandGateway commandGateway;

    @PostMapping("/api/v1/customers")
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody CreateCustomerDto dto) throws Exception {
        CreateCustomerCommand command = newCreateCustomerCommand(dto);
        commandGateway.send(command);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private CreateCustomerCommand newCreateCustomerCommand(CreateCustomerDto dto) {
        CreateCustomerCommand command = new CreateCustomerCommand();
        command.setFullName(dto.getFullName());
        command.setEmail(dto.getEmail());
        command.setPassword(dto.getPassword());
        return command;
    }

}
