package info.ballestriero.deviceStore.services.queries;

import info.ballestriero.deviceStore.entities.DeviceStoreQueryEntity;
import info.ballestriero.deviceStore.entities.repositories.DeviceStoreRepository;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceStoreQueryServiceImpl implements DeviceStoreQueryService {

    private final EventStore eventStore;

    private final DeviceStoreRepository deviceStoreRepository;

    public DeviceStoreQueryServiceImpl(EventStore eventStore, DeviceStoreRepository deviceStoreRepository) {
        this.eventStore = eventStore;
        this.deviceStoreRepository = deviceStoreRepository;
    }

    @Override
    public List<Object> listEventsForDevice(String serialNumber) {
        return eventStore.readEvents(serialNumber).asStream().map( s -> s.getPayload()).collect(Collectors.toList());
    }

    @Override
    public DeviceStoreQueryEntity getDevice(String serialNumber) {
        return deviceStoreRepository.findById(serialNumber).get();
    }
}
