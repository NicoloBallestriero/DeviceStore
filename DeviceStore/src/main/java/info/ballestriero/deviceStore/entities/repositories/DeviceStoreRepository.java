package info.ballestriero.deviceStore.entities.repositories;

import org.springframework.data.repository.CrudRepository;
import info.ballestriero.deviceStore.entities.DeviceStoreQueryEntity;

public interface DeviceStoreRepository extends CrudRepository<DeviceStoreQueryEntity, String> {
}
