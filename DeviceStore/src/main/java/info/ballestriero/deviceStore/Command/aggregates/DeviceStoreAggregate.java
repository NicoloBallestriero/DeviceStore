package info.ballestriero.deviceStore.Command.aggregates;

import info.ballestriero.deviceStore.Command.commands.CreateDeviceCommand;
import info.ballestriero.deviceStore.Command.commands.SetLocationCommand;
import info.ballestriero.deviceStore.Command.commands.SetStatusCommand;
import info.ballestriero.deviceStore.Command.events.*;

import java.time.LocalDateTime;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class DeviceStoreAggregate {

    @AggregateIdentifier
    private String serialNumber;
    private String firstSeen;
    private String location;
    private String status;

    public DeviceStoreAggregate() {
    	//Axon Requirement
    }

    @CommandHandler
    public DeviceStoreAggregate(CreateDeviceCommand createAccountCommand){
        AggregateLifecycle.apply(new DeviceCreatedEvent(createAccountCommand.serialNumber));
    }
    
    @CommandHandler
    protected void on(SetLocationCommand setLocationCommand){
        AggregateLifecycle.apply(new SetLocationEvent(setLocationCommand.serialNumber, setLocationCommand.location));
    }
    
    @CommandHandler
    protected void on(SetStatusCommand setStatusCommand){
    	AggregateLifecycle.apply(new SetStatusEvent(setStatusCommand.serialNumber, setStatusCommand.status));
    }

    @EventSourcingHandler
    protected void on(DeviceCreatedEvent deviceCreatedEvent){
        this.serialNumber = deviceCreatedEvent.serialNumber;
        this.firstSeen = deviceCreatedEvent.firstSeen;
        this.status = String.valueOf(Status.CREATED);
        AggregateLifecycle.apply(new SetStatusEvent(this.serialNumber, Status.ACTIVATED));
    }
  
    @EventSourcingHandler
    protected void on(SetStatusEvent setStatusEvent){
        this.status = String.valueOf(setStatusEvent.status);
    }
    
    @EventSourcingHandler
    protected void on(SetLocationEvent setLocationEvent){
        this.location = setLocationEvent.location;
    }
 
    public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getFirstSeen() {
		return firstSeen;
	}

	public void setFirstSeen(String firstSeen) {
		this.firstSeen = firstSeen;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

   
}
