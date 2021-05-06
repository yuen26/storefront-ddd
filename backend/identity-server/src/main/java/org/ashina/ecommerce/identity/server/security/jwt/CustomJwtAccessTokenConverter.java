package org.ashina.ecommerce.identity.server.security.jwt;

import com.google.common.collect.Maps;
import org.ashina.ecommerce.identity.server.security.userdetails.CustomUserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CustomJwtAccessTokenConverter extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        OAuth2Request request = authentication.getOAuth2Request();
        if (isPasswordGrantType(request) || isRefreshTokenGrantType(request)) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            final Map<String, Object> additionalInformation = new HashMap<>();
            additionalInformation.put("account_id", userDetails.getId());
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
        }
        accessToken = super.enhance(accessToken, authentication);
        // Clear additional information in /oauth/token response (only keep in JWT token)
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(Maps.newHashMap());
        return accessToken;
    }

    private boolean isPasswordGrantType(OAuth2Request request) {
        return Objects.nonNull(request.getGrantType())
                && request.getGrantType().equalsIgnoreCase("password");
    }

    private boolean isRefreshTokenGrantType(OAuth2Request request) {
        return Objects.nonNull(request.getRefreshTokenRequest())
                && request.getRefreshTokenRequest().getGrantType().equalsIgnoreCase("refresh_token");
    }
}
