package io.eventuate.tram.spring.events.subscriber;

import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

@Configuration
public class AnnotationBasedEventsSubscriberConfiguration {


  @Bean
  public EventuateDomainEventDispatcher eventuateDomainEventDispatcher(DomainEventDispatcherFactory domainEventDispatcherFactory) {
    return new EventuateDomainEventDispatcher(domainEventDispatcherFactory);
  }

  @Bean
  @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
  public EventuateDomainEventHandlerBeanPostProcessor eventuateDomainEventHandlerBeanPostProcessor(EventuateDomainEventDispatcher eventuateDomainEventDispatcher) {
    return new EventuateDomainEventHandlerBeanPostProcessor(eventuateDomainEventDispatcher);
  }
}
