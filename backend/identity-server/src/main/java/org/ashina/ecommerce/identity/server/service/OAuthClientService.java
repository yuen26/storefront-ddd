package org.ashina.ecommerce.identity.server.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.ashina.ecommerce.identity.server.dto.request.CreateOAuthClientRequest;
import org.ashina.ecommerce.identity.server.dto.response.CreateOAuthClientResponse;
import org.ashina.ecommerce.identity.server.model.OAuthClientDetails;
import org.ashina.ecommerce.identity.server.repository.OAuthClientDetailsRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OAuthClientService {

    // =================================================================================================================
    // Dependencies
    // =================================================================================================================

    private final OAuthClientDetailsRepository oAuthClientDetailsRepository;
    private final PasswordEncoder passwordEncoder;

    // =================================================================================================================
    // Constants
    // =================================================================================================================

    private static final int CLIENT_SECRET_LENGTH = 10;

    // =================================================================================================================
    // Public methods
    // =================================================================================================================

    @Transactional
    public CreateOAuthClientResponse createClient(CreateOAuthClientRequest reqDto) {
        if (oAuthClientDetailsRepository.findById(reqDto.getClientId()).isPresent()) {
            throw new IllegalArgumentException(
                    String.format("Client ID %s already exists", reqDto.getClientId())
            );
        }

        OAuthClientDetails clientDetails = new OAuthClientDetails();
        clientDetails.setClientId(reqDto.getClientId());
        String clientSecret = RandomStringUtils.random(CLIENT_SECRET_LENGTH, true, true);
        clientDetails.setClientSecret(passwordEncoder.encode(clientSecret));
        clientDetails.setScope(reqDto.getScope());
        clientDetails.setAuthorizedGrantTypes("authorization_code,password,refresh_token");
        clientDetails.setWebServerRedirectUri(reqDto.getWebServerRedirectUri());
        clientDetails.setAccessTokenValidity(2592000); // 30 days
        clientDetails.setRefreshTokenValidity(2592000);
        oAuthClientDetailsRepository.save(clientDetails);

        return new CreateOAuthClientResponse(clientDetails.getClientId(), clientSecret);
    }

    @Transactional
    public void deleteClient(String clientId) {
        oAuthClientDetailsRepository.deleteById(clientId);
    }
}
