package com.luxury.luxurycamp;

import com.luxury.luxurycamp.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseModel {

    private ObservableList<AccommodationDetails> accommodationDetails;

    public DatabaseModel() {
        accommodationDetails = FXCollections.observableArrayList();
        accommodationDetails.add(new AccommodationDetails(1, "Luxury Tent", "Occupied", "Available", new AccommodationArea("Woodland", "Area 1 Description", 2, 1), new CleaningStatus("Clean"), new AccommodationsReception("Nadine", "Smith", 12334345,2,"05-10-22", 2, false), new AccommodationInfo("Geodesic Dome",3,2,120.0, "")));
    }

    public ObservableList<AccommodationDetails> getAccommodationDetails() {
        return accommodationDetails;
    }

    public void setAccommodationDetails(ObservableList<AccommodationDetails> accommodationDetails) {
        this.accommodationDetails = accommodationDetails;
    }
}
