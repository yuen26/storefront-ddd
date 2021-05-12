package org.ashina.ecommerce.gateway.server.filter;

import com.nimbusds.jose.JWSObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.text.ParseException;

@Order(1)
@Slf4j
public class OAuthFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (!StringUtils.hasText(token)) {
            return chain.filter(exchange);
        }
        try {
            JWSObject jwsObject = JWSObject.parse(token.replace("Bearer ", ""));
            String userStr = jwsObject.getPayload().toString();
            ServerHttpRequest request = exchange.getRequest().mutate().header("user", userStr).build();
            exchange = exchange.mutate().request(request).build();
        } catch (ParseException e) {
            log.error("Parse JWT token failed", e);
        }
        return chain.filter(exchange);
    }
}
