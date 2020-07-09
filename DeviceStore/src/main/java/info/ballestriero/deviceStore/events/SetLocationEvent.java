package info.ballestriero.deviceStore.events;

public class SetLocationEvent extends BaseEvent<String> {

    public final String location;

    public SetLocationEvent(String serialNumber, String location) {
        super(serialNumber);
        this.location = location;
    }
}
