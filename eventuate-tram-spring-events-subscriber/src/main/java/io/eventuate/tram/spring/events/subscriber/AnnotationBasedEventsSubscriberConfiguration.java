package io.eventuate.tram.spring.events.subscriber;

import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AnnotationBasedEventsSubscriberConfiguration {


  @Bean
  public EventuateDomainEventDispatcher eventuateDomainEventDispatcher(DomainEventDispatcherFactory domainEventDispatcherFactory) {
    return new EventuateDomainEventDispatcher(domainEventDispatcherFactory);
  }

  @Bean
  public static EventuateDomainEventHandlerBeanPostProcessor eventuateDomainEventHandlerBeanPostProcessor( @Lazy EventuateDomainEventDispatcher eventuateDomainEventDispatcher) {
    return new EventuateDomainEventHandlerBeanPostProcessor(eventuateDomainEventDispatcher);
  }
}
