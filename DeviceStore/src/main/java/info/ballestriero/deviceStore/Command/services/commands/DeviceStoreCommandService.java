package info.ballestriero.deviceStore.Command.services.commands;

import java.util.concurrent.CompletableFuture;

import info.ballestriero.deviceStore.Command.dto.commands.DeviceCreateDTO;
import info.ballestriero.deviceStore.Command.dto.commands.SetLocationDTO;
import info.ballestriero.deviceStore.Command.dto.commands.SetStatusDTO;

public interface DeviceStoreCommandService {

    public CompletableFuture<String> createDevice(DeviceCreateDTO deviceCreateDTO);
    public CompletableFuture<String> setLocationToDevice(String serialNumber, SetLocationDTO setLocationDTO);
    public CompletableFuture<String> setStatusToDevice(String serialNumber, SetStatusDTO setStatusDTO);
}
