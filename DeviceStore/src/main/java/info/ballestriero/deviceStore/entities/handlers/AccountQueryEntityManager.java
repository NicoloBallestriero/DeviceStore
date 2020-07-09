package info.ballestriero.deviceStore.entities.handlers;


import info.ballestriero.deviceStore.aggregates.DeviceStoreAggregate;
import info.ballestriero.deviceStore.entities.DeviceStoreQueryEntity;
import info.ballestriero.deviceStore.entities.repositories.DeviceStoreRepository;
import info.ballestriero.deviceStore.events.BaseEvent;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccountQueryEntityManager {

    @Autowired
    private DeviceStoreRepository deviceStoreRepository;

    @Autowired
    @Qualifier("accountAggregateEventSourcingRepository")
    private EventSourcingRepository<DeviceStoreAggregate> accountAggregateEventSourcingRepository;

    @EventSourcingHandler
    void on(BaseEvent event){
        persistAccount(buildQueryAccount(getAccountFromEvent(event)));
    }


    private DeviceStoreAggregate getAccountFromEvent(BaseEvent event){
        return accountAggregateEventSourcingRepository.load(event.serialNumber.toString()).getWrappedAggregate().getAggregateRoot();
    }

    private DeviceStoreQueryEntity findExistingOrCreateQueryAccount(String serialNumber){
        return deviceStoreRepository.findById(serialNumber).isPresent() ? deviceStoreRepository.findById(serialNumber).get() : new DeviceStoreQueryEntity();
    }

    private DeviceStoreQueryEntity buildQueryAccount(DeviceStoreAggregate deviceStoreAggregate){
    	DeviceStoreQueryEntity deviceStoreQueryEntity = findExistingOrCreateQueryAccount(deviceStoreAggregate.getSerialNumber());

    	deviceStoreQueryEntity.setSerialNumber(deviceStoreAggregate.getSerialNumber());
    	deviceStoreQueryEntity.setFirstSeen(deviceStoreAggregate.getFirstSeen());
    	deviceStoreQueryEntity.setLocation(deviceStoreAggregate.getLocation());
    	deviceStoreQueryEntity.setStatus(deviceStoreAggregate.getStatus());

        return deviceStoreQueryEntity;
    }

    private void persistAccount(DeviceStoreQueryEntity deviceStoreQueryEntity){
    	deviceStoreRepository.save(deviceStoreQueryEntity);
    }
}
