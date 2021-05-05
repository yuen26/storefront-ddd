package org.ashina.ecommerce.sharedkernel.query.gateway;

import org.ashina.ecommerce.sharedkernel.query.handler.QueryHandler;
import org.ashina.ecommerce.sharedkernel.query.model.Query;
import org.ashina.ecommerce.sharedkernel.query.model.View;
import org.springframework.context.ApplicationContext;

import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DefaultQueryGateway extends QueryGateway {

    private final ApplicationContext applicationContext;
    private final Map<Class<? extends Query>, QueryHandler<Query, View>> handlerCache;

    public DefaultQueryGateway(Validator validator,
                               ApplicationContext applicationContext) {
        super(validator);
        this.applicationContext = applicationContext;
        this.handlerCache = new HashMap<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Optional<QueryHandler<Query, View>> lookupHandler(Query query) {
        QueryHandler<Query, View> handler = handlerCache.get(query.getClass());
        if (handler != null) {
            return Optional.of(handler);
        }
        Map<String, QueryHandler> handlerMap = applicationContext.getBeansOfType(QueryHandler.class);
        for (Map.Entry<String, QueryHandler> entry : handlerMap.entrySet()) {
            handler = entry.getValue();
            if (handler.support().equals(query.getClass())) {
                handlerCache.put(query.getClass(), handler);
                return Optional.of(handler);
            }
        }
        return Optional.empty();
    }

}
