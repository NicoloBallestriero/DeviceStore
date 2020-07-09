package info.ballestriero.deviceStore.services.commands;

import info.ballestriero.deviceStore.commands.CreateDeviceCommand;

import info.ballestriero.deviceStore.commands.SetLocationCommand;
import info.ballestriero.deviceStore.commands.SetStatusCommand;
import info.ballestriero.deviceStore.dto.commands.DeviceCreateDTO;

import info.ballestriero.deviceStore.dto.commands.SetLocationDTO;
import info.ballestriero.deviceStore.dto.commands.SetStatusDTO;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountCommandServiceImpl implements DeviceStoreCommandService {

    private final CommandGateway commandGateway;

    public AccountCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createDevice(DeviceCreateDTO deviceCreateDTO) {
    	return commandGateway.send(new CreateDeviceCommand(deviceCreateDTO.getSerialNumber()));
    }

    @Override
    public CompletableFuture<String> setLocationToDevice(String serialNumber, SetLocationDTO setLocationDTO) {
        return commandGateway.send(new SetLocationCommand(serialNumber, setLocationDTO.getLocation()));
    }

    @Override
    public CompletableFuture<String> setStatusToDevice(String serialNumber, SetStatusDTO setStatusDTO) {
        return commandGateway.send(new SetStatusCommand(serialNumber, setStatusDTO.getStatus()));
    }
}
