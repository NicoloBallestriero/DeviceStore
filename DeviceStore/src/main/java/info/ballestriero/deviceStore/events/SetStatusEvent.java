package info.ballestriero.deviceStore.events;

import info.ballestriero.deviceStore.aggregates.Status;

public class SetStatusEvent extends BaseEvent<String> {

    public final Status status;

    public SetStatusEvent(String serialNumber, Status status) {
        super(serialNumber);
        this.status = status;
    }
}
