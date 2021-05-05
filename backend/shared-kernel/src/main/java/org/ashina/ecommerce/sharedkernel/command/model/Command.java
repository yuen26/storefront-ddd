package org.ashina.ecommerce.sharedkernel.command.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Command {

    protected LocalDateTime createdAt;
    protected boolean hasValidate;

    protected Command() {
        this.createdAt = LocalDateTime.now();
        this.hasValidate = false;
    }
}
