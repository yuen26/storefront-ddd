package org.ashina.ecommerce.gateway.server.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

public class WebSecurityConfiguration {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        http
                .authorizeExchange()
                    .anyExchange()
                    .authenticated()
                .and()
                .oauth2ResourceServer()
                    .jwt();
        return http.build();
    }
}
