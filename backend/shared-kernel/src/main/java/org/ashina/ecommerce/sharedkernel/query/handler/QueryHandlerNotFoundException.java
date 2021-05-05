package org.ashina.ecommerce.sharedkernel.query.handler;

public class QueryHandlerNotFoundException extends RuntimeException {

    public QueryHandlerNotFoundException(String message) {
        super(message);
    }
}
