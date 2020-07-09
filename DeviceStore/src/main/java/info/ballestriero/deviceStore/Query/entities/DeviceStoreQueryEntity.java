package info.ballestriero.deviceStore.Query.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DeviceStoreQueryEntity {

    @Id
    private String serialNumber;

    private String firstSeen;

    private String status;
    
    private String location;

    public DeviceStoreQueryEntity() {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
    public String toString() {
        return "AccountQueryEntity{" +
                "serialNumber='" + serialNumber + '\'' +
                ", firstSeen=" + firstSeen +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
