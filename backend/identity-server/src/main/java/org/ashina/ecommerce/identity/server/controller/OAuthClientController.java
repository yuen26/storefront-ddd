package org.ashina.ecommerce.identity.server.controller;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.identity.server.dto.request.CreateOAuthClientRequest;
import org.ashina.ecommerce.identity.server.dto.response.CreateOAuthClientResponse;
import org.ashina.ecommerce.identity.server.service.OAuthClientService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class OAuthClientController {

    // =================================================================================================================
    // Dependencies
    // =================================================================================================================

    private final OAuthClientService clientService;

    // =================================================================================================================
    // APIs
    // =================================================================================================================

    @PostMapping("/oauth/clients")
    public CreateOAuthClientResponse createClient(@Valid @RequestBody CreateOAuthClientRequest reqDto) {
        return clientService.createClient(reqDto);
    }

    @DeleteMapping("/oauth/clients/{id}")
    public void deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
    }
}
