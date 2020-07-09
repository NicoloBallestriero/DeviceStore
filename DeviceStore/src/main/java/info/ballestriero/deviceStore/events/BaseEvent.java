package info.ballestriero.deviceStore.events;

public class BaseEvent<T> {

    public final T serialNumber;

    public BaseEvent(T serialNumber) {
        this.serialNumber = serialNumber;
    }
}
