package info.ballestriero.deviceStore.config;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import info.ballestriero.deviceStore.Command.aggregates.DeviceStoreAggregate;

@Configuration
public class AxonConfig {

    @Bean
    EventSourcingRepository<DeviceStoreAggregate> accountAggregateEventSourcingRepository(EventStore eventStore){
        EventSourcingRepository<DeviceStoreAggregate> repository = EventSourcingRepository.builder(DeviceStoreAggregate.class).eventStore(eventStore).build();
        return repository;
    }
}
