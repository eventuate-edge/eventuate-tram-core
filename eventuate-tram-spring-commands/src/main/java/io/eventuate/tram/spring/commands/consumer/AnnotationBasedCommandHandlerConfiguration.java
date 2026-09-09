package io.eventuate.tram.spring.commands.consumer;

import io.eventuate.tram.commands.consumer.CommandDispatcherFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AnnotationBasedCommandHandlerConfiguration {


    @Bean
    public EventuateCommandHandlerBeanPostProcessor eventuateCommandHandlerBeanPostProcessor(@Lazy EventuateCommandDispatcher eventuateCommandDispatcher) {
        return new EventuateCommandHandlerBeanPostProcessor(eventuateCommandDispatcher);
    }

    @Bean
    public EventuateCommandDispatcher eventuateCommandDispatcher(CommandDispatcherFactory commandDispatcherFactory) {
        return new EventuateCommandDispatcher(commandDispatcherFactory);
    }
}
