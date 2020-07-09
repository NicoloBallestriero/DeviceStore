package info.ballestriero.deviceStore.Command.events;

public class SetLocationEvent extends BaseEvent<String> {

    public final String location;

    public SetLocationEvent(String serialNumber, String location) {
        super(serialNumber);
        this.location = location;
    }
}
