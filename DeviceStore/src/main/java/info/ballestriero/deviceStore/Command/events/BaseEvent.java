package info.ballestriero.deviceStore.Command.events;

public class BaseEvent<T> {

    public final T serialNumber;

    public BaseEvent(T serialNumber) {
        this.serialNumber = serialNumber;
    }
}
