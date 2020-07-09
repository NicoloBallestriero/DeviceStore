package info.ballestriero.deviceStore.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCommand<T> {

    @TargetAggregateIdentifier
    public final T serialNumber;

    public BaseCommand(T serialNumber) {
        this.serialNumber = serialNumber;
    }
}
