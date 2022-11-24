package com.luxury.luxurycamp.models;


public class AccommodationsReception {
    private String firstName, lastName;
    private int telephoneNo, numberGuests;
    private String checkInDate;
    private int numberNights;
    private boolean breakfastRequired;

    public AccommodationsReception(String firstName, String lastName, int telephoneNo, int numberGuests, String checkInDate, int numberNights, boolean breakfastRequired) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNo = telephoneNo;
        this.numberGuests = numberGuests;
        this.checkInDate = checkInDate;
        this.numberNights = numberNights;
        this.breakfastRequired = breakfastRequired;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(int telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public int getNumberGuests() {
        return numberGuests;
    }

    public void setNumberGuests(int numberGuests) {
        this.numberGuests = numberGuests;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public int getNumberNights() {
        return numberNights;
    }

    public void setNumberNights(int numberNights) {
        this.numberNights = numberNights;
    }

    public boolean isBreakfastRequired() {
        return breakfastRequired;
    }

    public void setBreakfastRequired(boolean breakfastRequired) {
        this.breakfastRequired = breakfastRequired;
    }
}
