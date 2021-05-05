package org.ashina.ecommerce.sharedkernel.registry;

import org.ashina.ecommerce.sharedkernel.command.gateway.CommandGateway;
import org.ashina.ecommerce.sharedkernel.command.gateway.DefaultCommandGateway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validator;

@Configuration
public class CommandGatewayRegistry {

    @Bean
    public CommandGateway commandGateway(Validator validator,
                                         ApplicationContext applicationContext) {
        return new DefaultCommandGateway(validator, applicationContext);
    }

}
