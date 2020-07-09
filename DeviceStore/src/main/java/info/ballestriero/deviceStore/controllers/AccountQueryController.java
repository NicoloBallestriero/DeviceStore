package info.ballestriero.deviceStore.controllers;

import info.ballestriero.deviceStore.entities.DeviceStoreQueryEntity;
import info.ballestriero.deviceStore.services.queries.DeviceStoreQueryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/DeviceStore")
@Api(value = "DeviceStore Queries", description = "DeviceStore Query Events Endpoint", tags = "DeviceStore Queries")
public class AccountQueryController {

    private final DeviceStoreQueryService deviceStoreQueryService;

    public AccountQueryController(DeviceStoreQueryService deviceStoreQueryService) {
        this.deviceStoreQueryService = deviceStoreQueryService;
    }

    @GetMapping("/{accountNumber}")
    public DeviceStoreQueryEntity getDevice(@PathVariable(value = "accountNumber") String accountNumber){
        return deviceStoreQueryService.getDevice(accountNumber);
    }

    @GetMapping("/{accountNumber}/events")
    public List<Object> listEventsForDevice(@PathVariable(value = "accountNumber") String accountNumber){
        return deviceStoreQueryService.listEventsForDevice(accountNumber);
    }
    
}