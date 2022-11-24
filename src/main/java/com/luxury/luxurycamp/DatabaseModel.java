package com.luxury.luxurycamp;

import com.luxury.luxurycamp.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseModel {

    private ObservableList<AccommodationDetails> accommodationDetails;
    private ObservableList<CleaningStatus> cleaningStatuses;
    private ObservableList<AccommodationArea> accommodationAreas;

    public DatabaseModel() {
        accommodationDetails = FXCollections.observableArrayList();
        cleaningStatuses = FXCollections.observableArrayList();
        accommodationAreas = FXCollections.observableArrayList();
        accommodationDetails.add(new AccommodationDetails(1, "Luxury Tent", "Occupied", "Available", new AccommodationArea("Woodland", "Area 1 Description", 2, 1), new CleaningStatus("Clean"), new AccommodationsReception("Nadine", "Smith", 12334345, 2, "05-10-22", 2, true), new AccommodationInfo("Geodesic Dome", 3, 2, 120.0, "Hello")));
        cleaningStatuses.add(new CleaningStatus("Clean"));
        cleaningStatuses.add(new CleaningStatus("Requires Cleaning"));
        accommodationAreas.add(new AccommodationArea("Hilltop", "", 2, 0));
        accommodationAreas.add(new AccommodationArea("Wild Meadow", "", 2, 0));
        accommodationAreas.add(new AccommodationArea("Woodland", "", 2, 0));
        accommodationAreas.add(new AccommodationArea("Lakeview", "", 2, 0));
    }

    public ObservableList<AccommodationDetails> getAccommodationDetails() {
        return accommodationDetails;
    }

    public void setAccommodationDetails(ObservableList<AccommodationDetails> accommodationDetails) {
        this.accommodationDetails = accommodationDetails;
    }

    public ObservableList<CleaningStatus> getCleaningStatuses() {
        return cleaningStatuses;
    }

    public void setCleaningStatuses(ObservableList<CleaningStatus> cleaningStatuses) {
        this.cleaningStatuses = cleaningStatuses;
    }

    public ObservableList<AccommodationArea> getAccommodationAreas() {
        return accommodationAreas;
    }

    public void setAccommodationAreas(ObservableList<AccommodationArea> accommodationAreas) {
        this.accommodationAreas = accommodationAreas;
    }
}
