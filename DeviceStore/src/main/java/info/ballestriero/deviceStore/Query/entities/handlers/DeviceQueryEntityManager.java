package info.ballestriero.deviceStore.Query.entities.handlers;


import info.ballestriero.deviceStore.Command.aggregates.DeviceStoreAggregate;
import info.ballestriero.deviceStore.Command.entities.repositories.DeviceStoreRepository;
import info.ballestriero.deviceStore.Command.events.BaseEvent;
import info.ballestriero.deviceStore.Query.entities.DeviceStoreQueryEntity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DeviceQueryEntityManager {
	
	private EntityManager entityManager;
    @Autowired
    private DeviceStoreRepository deviceStoreRepository;

    @Autowired
    @Qualifier("accountAggregateEventSourcingRepository")
    private EventSourcingRepository<DeviceStoreAggregate> accountAggregateEventSourcingRepository;

    
    @EventSourcingHandler
    void on(BaseEvent event){
        persistDevice(buildQueryAccount(getAccountFromEvent(event)));
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

    private void persistDevice(DeviceStoreQueryEntity deviceStoreQueryEntity){
    	deviceStoreRepository.save(deviceStoreQueryEntity);
    }
}
