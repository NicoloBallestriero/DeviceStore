package info.ballestriero.deviceStore.Command.commands;

public class SetLocationCommand extends BaseCommand<String> {

    public final String location;

    public SetLocationCommand(String serialNumber, String location) {
        super(serialNumber);
        this.location = location;
    }
}
