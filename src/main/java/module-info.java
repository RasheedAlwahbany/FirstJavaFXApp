module com.luxury.luxurycamp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.luxury.luxurycamp to javafx.fxml;
    exports com.luxury.luxurycamp;
}