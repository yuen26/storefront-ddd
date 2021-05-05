package org.ashina.ecommerce.customer.application.rest.controller;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.customer.application.command.model.CreateAddressBookCommand;
import org.ashina.ecommerce.customer.application.command.model.UpdateAddressBookCommand;
import org.ashina.ecommerce.customer.application.query.model.GetAddressBookQuery;
import org.ashina.ecommerce.customer.application.query.model.GetAddressBookView;
import org.ashina.ecommerce.customer.application.rest.dto.CreateAddressBookDto;
import org.ashina.ecommerce.customer.application.rest.dto.UpdateAddressBookDto;
import org.ashina.ecommerce.sharedkernel.command.gateway.CommandGateway;
import org.ashina.ecommerce.sharedkernel.query.gateway.QueryGateway;
import org.ashina.ecommerce.sharedkernel.security.SecurityContextHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AddressBookController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @GetMapping("/api/v1/address-books")
    public ResponseEntity<GetAddressBookView> getAddressBook() throws Exception {
        GetAddressBookQuery query = newGetAddressBookQuery();
        GetAddressBookView view = (GetAddressBookView) queryGateway.execute(query);
        return new ResponseEntity<>(view, HttpStatus.OK);
    }

    private GetAddressBookQuery newGetAddressBookQuery() {
        GetAddressBookQuery query = new GetAddressBookQuery();
        query.setCustomerId(SecurityContextHelper.currentCustomerId());
        return query;
    }

    @PostMapping("/api/v1/address-books")
    public ResponseEntity<Void> createAddressBook(@Valid @RequestBody CreateAddressBookDto dto) throws Exception {
        CreateAddressBookCommand command = newCreateAddressBookCommand(dto);
        commandGateway.send(command);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private CreateAddressBookCommand newCreateAddressBookCommand(CreateAddressBookDto dto) {
        CreateAddressBookCommand command = new CreateAddressBookCommand();
        command.setCustomerId(SecurityContextHelper.currentCustomerId());
        command.setFullName(dto.getFullName());
        command.setPhoneNumber(dto.getPhoneNumber());
        command.setAddress(dto.getAddress());
        return command;
    }

    @PutMapping("/api/v1/address-books")
    public ResponseEntity<Void> updateAddressBook(@Valid @RequestBody UpdateAddressBookDto dto) throws Exception {
        UpdateAddressBookCommand command = newUpdateAddressBookCommand(dto);
        commandGateway.send(command);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private UpdateAddressBookCommand newUpdateAddressBookCommand(UpdateAddressBookDto dto) {
        UpdateAddressBookCommand command = new UpdateAddressBookCommand();
        command.setCustomerId(SecurityContextHelper.currentCustomerId());
        command.setFullName(dto.getFullName());
        command.setPhoneNumber(dto.getPhoneNumber());
        command.setAddress(dto.getAddress());
        return command;
    }
}
