package com.luxury.luxurycamp.models;

public class AccommodationInfo {
    private String accommType;
    private int accommNumber;
    private int accommDates;
    private double pricePerNight;
    private String notes;

    public AccommodationInfo(String accommType, int accommNumber, int accommDates, double pricePerNight, String notes) {
        this.accommType = accommType;
        this.accommNumber = accommNumber;
        this.accommDates = accommDates;
        this.pricePerNight = pricePerNight;
        this.notes = notes;
    }


    public String getAccommType() {
        return accommType;
    }

    public void setAccommType(String accommType) {
        this.accommType = accommType;
    }

    public int getAccommNumber() {
        return accommNumber;
    }

    public void setAccommNumber(int accommNumber) {
        this.accommNumber = accommNumber;
    }

    public int getAccommDates() {
        return accommDates;
    }

    public void setAccommDates(int accommDates) {
        this.accommDates = accommDates;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
