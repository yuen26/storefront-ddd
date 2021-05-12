package org.ashina.ecommerce.customer.infrastructure.identity.internal.adapter;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.customer.domain.Customer;
import org.ashina.ecommerce.customer.infrastructure.identity.IdentityService;
import org.ashina.ecommerce.customer.infrastructure.identity.internal.model.CreateAccountRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class InternalIdentityService implements IdentityService {

    private final RestTemplate restTemplate;

    @Value("${identity.internal.endpoint}")
    private String endpoint;

    @Override
    public void save(Customer customer, String password) {
        CreateAccountRequest request = new CreateAccountRequest(customer, password);
        restTemplate.postForObject(endpoint, request, Void.class);
    }
}
