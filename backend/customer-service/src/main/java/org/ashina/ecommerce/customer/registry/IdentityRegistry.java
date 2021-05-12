package org.ashina.ecommerce.customer.registry;

import org.ashina.ecommerce.customer.infrastructure.identity.IdentityService;
import org.ashina.ecommerce.customer.infrastructure.identity.internal.adapter.InternalIdentityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class IdentityRegistry {

    @Bean
    public IdentityService identityService(RestTemplate restTemplate) {
        return new InternalIdentityService(restTemplate);
    }
}
