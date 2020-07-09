package info.ballestriero.deviceStore.commands;

import info.ballestriero.deviceStore.aggregates.Status;

public class SetStatusCommand extends BaseCommand<String> {

    public final Status status;

    public SetStatusCommand(String serialNumber, Status status) {
        super(serialNumber);
        this.status = status;
    }
}
