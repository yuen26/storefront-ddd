package org.ashina.ecommerce.sharedkernel.command.handler;

public class CommandHandlerNotFoundException extends RuntimeException {

    public CommandHandlerNotFoundException(String message) {
        super(message);
    }

}
