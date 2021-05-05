package org.ashina.ecommerce.sharedkernel.command.gateway;

import org.ashina.ecommerce.sharedkernel.command.handler.CommandHandler;
import org.ashina.ecommerce.sharedkernel.command.model.Command;
import org.springframework.context.ApplicationContext;

import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DefaultCommandGateway extends CommandGateway {

    private final ApplicationContext applicationContext;
    private final Map<Class<? extends Command>, CommandHandler<Command>> handlerCache;

    public DefaultCommandGateway(Validator validator,
                                 ApplicationContext applicationContext) {
        super(validator);
        this.applicationContext = applicationContext;
        this.handlerCache = new HashMap<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Optional<CommandHandler<Command>> lookupHandler(Command command) {
        CommandHandler<Command> handler = handlerCache.get(command.getClass());
        if (handler != null) {
            return Optional.of(handler);
        }
        Map<String, CommandHandler> handlerMap = applicationContext.getBeansOfType(CommandHandler.class);
        for (Map.Entry<String, CommandHandler> entry : handlerMap.entrySet()) {
            handler = entry.getValue();
            if (handler.support().equals(command.getClass())) {
                handlerCache.put(command.getClass(), handler);
                return Optional.of(handler);
            }
        }
        return Optional.empty();
    }
}
