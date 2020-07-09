package info.ballestriero.deviceStore.Command.events;

import info.ballestriero.deviceStore.Command.aggregates.Status;

public class SetStatusEvent extends BaseEvent<String> {

    public final Status status;

    public SetStatusEvent(String serialNumber, Status status) {
        super(serialNumber);
        this.status = status;
    }
}
