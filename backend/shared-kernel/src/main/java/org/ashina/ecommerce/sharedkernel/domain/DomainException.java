package org.ashina.ecommerce.sharedkernel.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DomainException extends Exception {

    private final String errorCode;
    private final String errorMessage;

    public static DomainException of(String errorCode, String errorMessage) {
        return new DomainException(errorCode, errorMessage);
    }
}
