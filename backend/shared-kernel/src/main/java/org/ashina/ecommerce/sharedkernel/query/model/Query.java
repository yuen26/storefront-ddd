package org.ashina.ecommerce.sharedkernel.query.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Query {

    protected LocalDateTime createdAt;
    protected boolean hasValidate;

    protected Query() {
        this.createdAt = LocalDateTime.now();
        this.hasValidate = false;
    }
}
