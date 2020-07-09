package info.ballestriero.deviceStore.controllers;


import info.ballestriero.deviceStore.dto.commands.DeviceCreateDTO;
import info.ballestriero.deviceStore.dto.commands.SetLocationDTO;
import info.ballestriero.deviceStore.dto.commands.SetStatusDTO;
import info.ballestriero.deviceStore.services.commands.DeviceStoreCommandService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/DeviceStore")
@Api(value = "DeviceStore Commands", description = "DeviceStore Commands Related Endpoints", tags = "DeviceStore Commands")
public class AccountCommandController {

    private final DeviceStoreCommandService deviceStoreCommandService;

    public AccountCommandController(DeviceStoreCommandService deviceStoreCommandService) {
        this.deviceStoreCommandService = deviceStoreCommandService;
    }

    @PostMapping
    public CompletableFuture<String> createDevice(@RequestBody DeviceCreateDTO deviceCreateDTO){
        return deviceStoreCommandService.createDevice(deviceCreateDTO);
    }

    @PutMapping(value = "setLocation/device/{serialNumber}")
    public CompletableFuture<String> setLocationToDevice(@PathVariable(value = "serialNumber") String serialNumber,
                                                          @RequestBody SetLocationDTO setLocationDTO){
        return deviceStoreCommandService.setLocationToDevice(serialNumber, setLocationDTO);
    }

    @PutMapping(value = "setStatus/device/{serialNumber}")
    public CompletableFuture<String> setStatusToDevice(@PathVariable(value = "serialNumber") String serialNumber,
                                                           @RequestBody SetStatusDTO setStatusDTO){
        return deviceStoreCommandService.setStatusToDevice(serialNumber, setStatusDTO);
    }
}
