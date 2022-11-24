package com.luxury.luxurycamp;

import com.luxury.luxurycamp.models.AccommodationArea;
import com.luxury.luxurycamp.models.AccommodationDetails;
import com.luxury.luxurycamp.models.CleaningStatus;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private TextField areaDescription, breakfastNo, requireCleaning;

    @FXML
    private ComboBox<CleaningStatus> cleaningStatus;

    @FXML
    private TextField accomInfoType, accomInfoAccommodates, accomInfoNo, accomInfoPricePerNight, accomInfoNotes;

    @FXML
    private TextField receptionFName, receptionLName, receptionNo, receptionNoOfGuest, receptionCheckInDate, receptionnumberNight;

    @FXML
    private CheckBox receptionIsBreakfastRequired;

    @FXML
    private Button receptionCheckIn, receptionCheckOut;


    private void setAccommdatesInformatios(AccommodationDetails row) {
        area.setValue(row.getArea());
        areaDescription.setText(row.getArea().getDescription());
        breakfastNo.setText(row.getArea().getNumOfBreakfast() + "");
        requireCleaning.setText(row.getArea().getNumRequireCleaning() + "");

        cleaningStatus.setValue(row.getCleaningStatus());
        accomInfoType.setText(row.getAccommodationInfo().getAccommType() + "");
        accomInfoAccommodates.setText(row.getAccommodationInfo().getAccommDates() + "");
        accomInfoNo.setText(row.getAccommodationInfo().getAccommNumber() + "");
        accomInfoPricePerNight.setText(row.getAccommodationInfo().getPricePerNight() + "");


        receptionFName.setText(row.getReception().getFirstName());
        receptionLName.setText(row.getReception().getLastName());
        receptionNo.setText(row.getReception().getTelephoneNo() + "");
        receptionNoOfGuest.setText(row.getReception().getNumberGuests() + "");
        receptionCheckInDate.setText(row.getReception().getCheckInDate());
        receptionnumberNight.setText(row.getReception().getNumberNights() + "");
        receptionnumberNight.setText(row.getReception().getNumberNights() + "");
        accomInfoNotes.setText(row.getAccommodationInfo().getNotes());
        receptionIsBreakfastRequired.setSelected(row.getReception().isBreakfastRequired());
        System.out.println(receptionNoOfGuest.getText());
        if (receptionNoOfGuest.getText().equals("0")) {
            receptionCheckIn.setDisable(false);
            receptionCheckOut.setDisable(true);
        } else if (!receptionNoOfGuest.getText().equals("0")) {
            receptionCheckIn.setDisable(true);
            receptionCheckOut.setDisable(false);
        }
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



        cleaningStatus.valueProperty().addListener(new ChangeListener<CleaningStatus>() {
            @Override
            public void changed(ObservableValue<? extends CleaningStatus> observableValue, CleaningStatus oldValue, CleaningStatus newValue) {
                toggleCleanStatus(oldValue,newValue);
            }
        });

        if (receptionNoOfGuest.getText().equals("0")) {
            receptionCheckIn.setDisable(true);
            receptionCheckOut.setDisable(false);
        } else if (!receptionNoOfGuest.getText().equals("0")) {
            receptionCheckIn.setDisable(false);
            receptionCheckOut.setDisable(true);
        }
    }

    @FXML
    void tableSelectedItem() {
        AccommodationDetails item = tableView.getSelectionModel().getSelectedItem();
        setAccommdatesInformatios(item);
    }


    @FXML
    void checkIn() {
        AccommodationDetails detailsRow = null;
        int position = -1;
        ObservableList<AccommodationDetails> details = databaseModel.getAccommodationDetails();
        AccommodationDetails item = tableView.getSelectionModel().getSelectedItem();
        for (int i = 0; i < details.size(); i++) {
            detailsRow = details.get(i);
            if (detailsRow == item) {
                position = i;
                break;
            }
        }
        if (position >= 0) {
            if (Integer.parseInt(receptionNoOfGuest.getText()) > 0) {
                detailsRow.getCleaningStatus().setStatus("Clean");
                detailsRow.setAvailability("Unavailable");
                detailsRow.setOccupancy("Occupied");
                receptionCheckIn.setDisable(false);
                receptionCheckOut.setDisable(true);
            }
            detailsRow.getArea().setDescription(areaDescription.getText());
            if (!breakfastNo.getText().matches(""))
                detailsRow.getArea().setNumOfBreakfast(Integer.parseInt(breakfastNo.getText()));
            else
                detailsRow.getArea().setNumOfBreakfast(0);
            detailsRow.getArea().setNumRequireCleaning(Integer.parseInt(requireCleaning.getText()));
            detailsRow.getCleaningStatus().setStatus("Clean");
            detailsRow.getReception().setFirstName(receptionFName.getText());
            detailsRow.getReception().setLastName(receptionLName.getText());
            if (!breakfastNo.getText().matches(""))
                detailsRow.getReception().setTelephoneNo(Integer.parseInt(breakfastNo.getText()));
            else
                detailsRow.getReception().setTelephoneNo(0);
            if (!receptionNoOfGuest.getText().matches(""))
                detailsRow.getReception().setNumberGuests(Integer.parseInt(receptionNoOfGuest.getText()));
            else
                detailsRow.getReception().setNumberGuests(0);
            detailsRow.getReception().setCheckInDate(receptionCheckInDate.getText());
            if (!receptionnumberNight.getText().matches(""))
                detailsRow.getReception().setNumberNights(Integer.parseInt(receptionnumberNight.getText()));
            else
                detailsRow.getReception().setNumberNights(0);
            detailsRow.getReception().setBreakfastRequired(receptionIsBreakfastRequired.isSelected());
            detailsRow.getAccommodationInfo().setAccommType(accomInfoType.getText());
            if (!accomInfoType.getText().matches(""))
                detailsRow.getAccommodationInfo().setAccommNumber(Integer.parseInt(accomInfoNo.getText()));
            else
                detailsRow.getAccommodationInfo().setAccommNumber(0);
            if (!accomInfoAccommodates.getText().matches(""))
                detailsRow.getAccommodationInfo().setAccommDates(Integer.parseInt(accomInfoAccommodates.getText()));
            else
                detailsRow.getAccommodationInfo().setAccommDates(0);
            if (!accomInfoPricePerNight.getText().matches(""))
                detailsRow.getAccommodationInfo().setPricePerNight(Double.parseDouble(accomInfoPricePerNight.getText()));
            else
                detailsRow.getAccommodationInfo().setPricePerNight(0);
            detailsRow.getAccommodationInfo().setNotes(accomInfoNotes.getText());

            if (position >= 0)
                details.set(position, detailsRow);
            else
                details.add(detailsRow);
        }
        databaseModel.setAccommodationDetails(details);

    }

    @FXML
    void checkOut() {
        AccommodationDetails detailsRow = null;
        int position = -1;
        ObservableList<AccommodationDetails> details = databaseModel.getAccommodationDetails();
        AccommodationDetails item = tableView.getSelectionModel().getSelectedItem();
        for (int i = 0; i < details.size(); i++) {
            detailsRow = details.get(i);
            if (detailsRow == item) {
                position = i;
                break;
            }
        }
        if (position >= 0) {
            detailsRow.getCleaningStatus().setStatus("Requires Cleaning");
            detailsRow.setAvailability("Unavailable");
            detailsRow.setOccupancy("Unoccupied");
            cleaningStatus.setValue(new CleaningStatus("Requires Cleaning"));
            detailsRow.getReception().setNumberGuests(0);
            if (position >= 0)
                details.set(position, detailsRow);
            else
                details.add(detailsRow);
            databaseModel.setAccommodationDetails(details);
        }
    }

    @FXML
    void logOut() {

    }

    void toggleCleanStatus(CleaningStatus oldValue,CleaningStatus newValue){
        AccommodationDetails detailsRow = null;
        int position = -1;
        ObservableList<AccommodationDetails> details = databaseModel.getAccommodationDetails();
        AccommodationDetails item = tableView.getSelectionModel().getSelectedItem();
        for (int i = 0; i < details.size(); i++) {
            detailsRow = details.get(i);
            if (detailsRow == item) {
                position = i;
                break;
            }
        }
        if (position >= 0) {
            if(newValue.getStatus().equals("Clean")) {
                detailsRow.getCleaningStatus().setStatus(newValue.getStatus());
                detailsRow.setAvailability("Available");
                detailsRow.getReception().setNumberGuests(0);
                if (position >= 0)
                    details.set(position, detailsRow);
                else
                    details.add(detailsRow);
            }
            databaseModel.setAccommodationDetails(details);
        }
    }
}
