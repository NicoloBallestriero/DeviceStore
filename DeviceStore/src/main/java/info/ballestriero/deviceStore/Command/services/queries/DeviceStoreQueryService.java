package info.ballestriero.deviceStore.Command.services.queries;

import java.util.List;

import info.ballestriero.deviceStore.Query.entities.DeviceStoreQueryEntity;

public interface DeviceStoreQueryService {
    public List<Object> listEventsForDevice(String serialNumber);
    public DeviceStoreQueryEntity getDevice(String serialNumber);
}
