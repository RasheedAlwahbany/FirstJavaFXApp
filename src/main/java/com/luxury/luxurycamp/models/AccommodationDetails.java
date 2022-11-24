package com.luxury.luxurycamp.models;

public class AccommodationDetails {
    private int no;
    private String accommType;
    private String occupancy;
    private String availability;
    private AccommodationArea area;
    private CleaningStatus cleaningStatus;
    private AccommodationsReception reception;
    private AccommodationInfo accommodationInfo;

    public AccommodationDetails(int no, String accommType, String occupancy, String availability, AccommodationArea area, CleaningStatus cleaningStatus, AccommodationsReception reception, AccommodationInfo accommodationInfo) {
        this.no = no;
        this.accommType = accommType;
        this.occupancy = occupancy;
        this.availability = availability;
        this.area = area;
        this.cleaningStatus = cleaningStatus;
        this.reception = reception;
        this.accommodationInfo = accommodationInfo;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getAccommType() {
        return accommType;
    }

    public void setAccommType(String accommType) {
        this.accommType = accommType;
    }

    public String getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(String occupancy) {
        this.occupancy = occupancy;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public AccommodationArea getArea() {
        return area;
    }

    public void setArea(AccommodationArea area) {
        this.area = area;
    }

    public CleaningStatus getCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(CleaningStatus cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    public AccommodationsReception getReception() {
        return reception;
    }

    public void setReception(AccommodationsReception reception) {
        this.reception = reception;
    }

    public AccommodationInfo getAccommodationInfo() {
        return accommodationInfo;
    }

    public void setAccommodationInfo(AccommodationInfo accommodationInfo) {
        this.accommodationInfo = accommodationInfo;
    }
}
