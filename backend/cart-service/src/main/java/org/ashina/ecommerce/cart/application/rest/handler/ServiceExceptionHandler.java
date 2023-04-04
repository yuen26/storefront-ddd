package org.ashina.ecommerce.cart.application.rest.handler;

import lombok.Getter;
import lombok.Setter;
import org.ashina.ecommerce.cart.application.error.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ServiceExceptionHandler {

    @Getter
    @Setter
    public static class Response {
        private String errorCode;
        private String errorMessage;
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Response> handleServiceException(ServiceException e) {
        Response response = new Response();
        response.setErrorCode(e.getErrorCode());
        response.setErrorMessage(e.getErrorMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(response);
    }
}
