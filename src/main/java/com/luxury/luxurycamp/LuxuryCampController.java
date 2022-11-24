package com.luxury.luxurycamp;

import com.luxury.luxurycamp.models.AccommodationArea;
import com.luxury.luxurycamp.models.AccommodationDetails;
import com.luxury.luxurycamp.models.CleaningStatus;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LuxuryCampController {
    DatabaseModel databaseModel = new DatabaseModel();
    @FXML
    private TableView<AccommodationDetails> tableView;

    @FXML
    private TableColumn<AccommodationDetails, String> noColumn;

    @FXML
    private TableColumn<AccommodationDetails, String> accommTypeColumn;

    @FXML
    private TableColumn<AccommodationDetails, String> occupancyColumn;

    @FXML
    private TableColumn<AccommodationDetails, String> availabilityColumn;

    @FXML
    private TableColumn<AccommodationDetails, String> statusColumn;

    @FXML
    private TableColumn<AccommodationDetails, String> guestsColumn;
    @FXML
    private TableColumn<AccommodationDetails, String> breakfastColumn;

    @FXML
    private ComboBox<AccommodationArea> area;
    @FXML
    private ComboBox<CleaningStatus> cleaningStatus;

    @FXML
    void initialize() {
        cleaningStatus.setItems(databaseModel.getCleaningStatuses());
        area.setItems(databaseModel.getAccommodationAreas());
        noColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNo() + ""));
        accommTypeColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAccommType()));
        occupancyColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getOccupancy()));
        availabilityColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAvailability()));
        statusColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCleaningStatus().getStatus()));
        guestsColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getReception().getNumberGuests() + ""));
        breakfastColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getReception().isBreakfastRequired() + ""));
        tableView.setItems(databaseModel.getAccommodationDetails());
    }
}
