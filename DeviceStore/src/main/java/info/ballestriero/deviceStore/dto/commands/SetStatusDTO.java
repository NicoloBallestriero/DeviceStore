package info.ballestriero.deviceStore.dto.commands;

import info.ballestriero.deviceStore.aggregates.Status;

public class SetStatusDTO {

    private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
