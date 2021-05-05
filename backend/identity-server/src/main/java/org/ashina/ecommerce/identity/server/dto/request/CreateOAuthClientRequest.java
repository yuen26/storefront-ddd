package org.ashina.ecommerce.identity.server.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateOAuthClientRequest {

    @NotBlank
    private String clientId;

    @NotBlank
    private String scope;

    @NotBlank
    private String webServerRedirectUri;
}
