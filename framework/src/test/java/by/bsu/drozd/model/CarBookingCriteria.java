package by.bsu.drozd.model;

import java.util.Objects;

public class CarBookingCriteria {
    private String pickUpLocation;
    private String dropOffLocation;
    private String pickUpDate;
    private String dropOffDate;
    private String pickUpTime;
    private String dropOffTime;

    public CarBookingCriteria(String pickUpLocation, String dropOffLocation,
                              String pickUpDate, String dropOffDate, String pickUpTime, String dropOffTime) {
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
    }

    public CarBookingCriteria(String pickUpLocation, String dropOffLocation, String pickUpDate, String dropOffDate) {
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
    }

    public CarBookingCriteria(String pickUpLocation, String pickUpDate, String dropOffDate, String pickUpTime,
                              String dropOffTime) {
        this.pickUpLocation = pickUpLocation;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
    }

    public CarBookingCriteria(String pickUpLocation, String dropOffLocation) {
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropOffLocation() { return dropOffLocation; }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(String dropOffTime) { this.dropOffTime = dropOffTime;  }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarBookingCriteria that = (CarBookingCriteria) o;
        return Objects.equals(pickUpLocation, that.pickUpLocation) &&
                Objects.equals(dropOffLocation, that.dropOffLocation) &&
                Objects.equals(pickUpDate, that.pickUpDate) &&
                Objects.equals(dropOffDate, that.dropOffDate) &&
                Objects.equals(pickUpTime, that.pickUpTime) &&
                Objects.equals(dropOffTime, that.dropOffTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pickUpLocation, dropOffLocation, pickUpDate, dropOffDate,pickUpTime, dropOffTime);
    }
}
