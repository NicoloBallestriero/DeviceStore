package info.ballestriero.deviceStore.services.queries;

import java.util.List;
import info.ballestriero.deviceStore.entities.DeviceStoreQueryEntity;

public interface DeviceStoreQueryService {
    public List<Object> listEventsForDevice(String serialNumber);
    public DeviceStoreQueryEntity getDevice(String serialNumber);
}
