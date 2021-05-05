package org.ashina.ecommerce.customer.registry;

import org.ashina.ecommerce.customer.application.query.handler.GetAddressBookQueryHandler;
import org.ashina.ecommerce.customer.infrastructure.persistence.AddressBookPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryHandlerRegistry {

    @Bean
    public GetAddressBookQueryHandler getAddressBookQueryHandler(AddressBookPersistence addressBookPersistence) {
        return new GetAddressBookQueryHandler(addressBookPersistence);
    }
}
