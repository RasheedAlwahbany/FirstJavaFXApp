package com.luxury.luxurycamp;

import com.luxury.luxurycamp.models.AccommodationDetails;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LuxuryCampController {
    DatabaseModel databaseModel = new DatabaseModel();
    @FXML
    private TableView<AccommodationDetails> tableView;

    @FXML
    private TableColumn<AccommodationDetails, String> noC;

    @FXML
    private TableColumn<AccommodationDetails, String> accommTypeC;

    @FXML
    private TableColumn<AccommodationDetails, String> occupancyC;

    @FXML
    private TableColumn<AccommodationDetails, String> availabilityC;

    @FXML
    private TableColumn<AccommodationDetails, String> statusC;

    @FXML
    private TableColumn<AccommodationDetails, String> guestsC;
    @FXML
    private TableColumn<AccommodationDetails, String> breakfastC;

    public LuxuryCampController() {

    }

    @FXML
    void initialize() {
        noC.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNo() + ""));
        accommTypeC.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAccommType()));
        occupancyC.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getOccupancy()));
        availabilityC.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAvailability()));
        statusC.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCleaningStatus().getStatus()));
        guestsC.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getReception().getNumberGuests() + ""));
        breakfastC.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getReception().isBreakfastRequired() + ""));
        tableView.setItems(databaseModel.getAccommodationDetails());
    }
}
