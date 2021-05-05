package org.ashina.ecommerce.identity.server.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateOAuthClientResponse {

    private String clientId;

    private String clientSecret;
}
