package org.ashina.ecommerce.identity.server.security;

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
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        OAuth2Request oAuth2Request = oAuth2Authentication.getOAuth2Request();
        if (isPasswordGrantType(oAuth2Request) || isRefreshTokenGrantType(oAuth2Request)) {
            CustomUser userDetails = (CustomUser) oAuth2Authentication.getUserAuthentication().getPrincipal();
            Map<String, Object> additionalInformation = new HashMap<>();
            additionalInformation.put("id", userDetails.getId());
            ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInformation);
        }
        return super.enhance(oAuth2AccessToken, oAuth2Authentication);
    }

    private boolean isPasswordGrantType(OAuth2Request oAuth2Request) {
        return Objects.nonNull(oAuth2Request.getGrantType())
                && oAuth2Request.getGrantType().equalsIgnoreCase("password");
    }

    private boolean isRefreshTokenGrantType(OAuth2Request oAuth2Request) {
        return Objects.nonNull(oAuth2Request.getRefreshTokenRequest())
                && oAuth2Request.getRefreshTokenRequest().getGrantType().equalsIgnoreCase("refresh_token");
    }
}
