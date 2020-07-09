package info.ballestriero.deviceStore.commands;

import java.time.LocalDateTime;

public class CreateDeviceCommand extends BaseCommand<String> {

    public final String firstSeen;

    public CreateDeviceCommand(String serialNumber) {
        super(serialNumber);
        this.firstSeen = LocalDateTime.now().toString();
        
    }
}
