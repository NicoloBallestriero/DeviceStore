package info.ballestriero.deviceStore.Command.services.queries;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import info.ballestriero.deviceStore.Command.entities.repositories.DeviceStoreRepository;
import info.ballestriero.deviceStore.Query.entities.DeviceStoreQueryEntity;

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
