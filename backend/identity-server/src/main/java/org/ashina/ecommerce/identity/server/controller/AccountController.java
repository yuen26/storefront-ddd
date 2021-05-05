package org.ashina.ecommerce.identity.server.controller;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.identity.server.dto.request.CreateAccountRequest;
import org.ashina.ecommerce.identity.server.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/api/v1/accounts")
    public ResponseEntity<Void> createAccount(@Valid @RequestBody CreateAccountRequest request) {
        accountService.save(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
