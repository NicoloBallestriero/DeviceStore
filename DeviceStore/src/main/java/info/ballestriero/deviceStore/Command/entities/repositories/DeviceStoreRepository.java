package info.ballestriero.deviceStore.Command.entities.repositories;

import org.springframework.data.repository.CrudRepository;

import info.ballestriero.deviceStore.Query.entities.DeviceStoreQueryEntity;

public interface DeviceStoreRepository extends CrudRepository<DeviceStoreQueryEntity, String> {
}
