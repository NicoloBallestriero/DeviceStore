package info.ballestriero.deviceStore.Command.events;

import java.time.LocalDateTime;

public class DeviceCreatedEvent extends BaseEvent<String> {


    public final String firstSeen;

    public DeviceCreatedEvent(String serialNumber) {
        super(serialNumber);
        this.firstSeen = LocalDateTime.now().toString();
    }
}
