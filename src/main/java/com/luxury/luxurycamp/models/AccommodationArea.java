package com.luxury.luxurycamp.models;

public class AccommodationArea {
    private String area;
    private String description;
    private  int numOfBreakfast;
    private  int numRequireCleaning;

    public AccommodationArea(String area, String description, int numOfBreakfast, int numRequireCleaning) {
        this.area = area;
        this.description = description;
        this.numOfBreakfast = numOfBreakfast;
        this.numRequireCleaning = numRequireCleaning;
    }


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumOfBreakfast() {
        return numOfBreakfast;
    }

    public void setNumOfBreakfast(int numOfBreakfast) {
        this.numOfBreakfast = numOfBreakfast;
    }

    public int getNumRequireCleaning() {
        return numRequireCleaning;
    }

    public void setNumRequireCleaning(int numRequireCleaning) {
        this.numRequireCleaning = numRequireCleaning;
    }

    @Override
    public String toString() {
        return area;
    }
}

