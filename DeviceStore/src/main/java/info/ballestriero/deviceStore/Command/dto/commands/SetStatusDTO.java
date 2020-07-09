package info.ballestriero.deviceStore.Command.dto.commands;

import info.ballestriero.deviceStore.Command.aggregates.Status;

public class SetStatusDTO {

    private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
