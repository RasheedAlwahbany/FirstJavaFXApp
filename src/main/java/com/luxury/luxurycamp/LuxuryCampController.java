package com.luxury.luxurycamp;

import com.luxury.luxurycamp.models.AccommodationArea;
import com.luxury.luxurycamp.models.AccommodationDetails;
import com.luxury.luxurycamp.models.AccommodationsReception;
import com.luxury.luxurycamp.models.CleaningStatus;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private TextField areaDescription,breakfastNo,requireCleaning;

    @FXML
    private ComboBox<CleaningStatus> cleaningStatus;

    @FXML
    private TextField accomInfoType,accomInfoAccommodates,accomInfoNo,accomInfoPricePerNight,accomInfoNotes;

    @FXML
    private TextField receptionFName,receptionLName,receptionNo,receptionNoOfGuest,receptionCheckInDate,receptionnumberNight;

    @FXML
    private CheckBox receptionIsBreakfastRequired;


    private void setAccommdatesInformatios(AccommodationDetails row){
        area.setValue(row.getArea());
        areaDescription.setText(row.getArea().getDescription());
        breakfastNo.setText(row.getArea().getNumOfBreakfast()+"");
        requireCleaning.setText(row.getArea().getNumRequireCleaning()+"");

        cleaningStatus.setValue(row.getCleaningStatus());
        accomInfoType.setText(row.getAccommodationInfo().getAccommType()+"");
        accomInfoAccommodates.setText(row.getAccommodationInfo().getAccommDates()+"");
        accomInfoNo.setText(row.getAccommodationInfo().getAccommNumber()+"");
        accomInfoPricePerNight.setText(row.getAccommodationInfo().getPricePerNight()+"");


        receptionFName.setText(row.getReception().getFirstName());
        receptionLName.setText(row.getReception().getLastName());
        receptionNo.setText(row.getReception().getTelephoneNo()+"");
        receptionNoOfGuest.setText(row.getReception().getNumberGuests()+"");
        receptionCheckInDate.setText(row.getReception().getCheckInDate());
        receptionnumberNight.setText(row.getReception().getNumberNights()+"");
        receptionnumberNight.setText(row.getReception().getNumberNights()+"");
        accomInfoNotes.setText(row.getAccommodationInfo().getNotes());
        receptionIsBreakfastRequired.setSelected(row.getReception().isBreakfastRequired());

    }
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

    @FXML
    void tableSelectedItem(){
        TablePosition pos = tableView.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        AccommodationDetails item = tableView.getItems().get(row);
        setAccommdatesInformatios(item);
    }


    @FXML
    void checkIn(){

    }

    @FXML
    void checkOut(){

    }
    @FXML
    void logOut(){

    }
}
