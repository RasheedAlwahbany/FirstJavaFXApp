package com.luxury.luxurycamp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCancel;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;

    public LoginController() {
    }

    public void userLogin(ActionEvent actionEvent) throws Exception {
        checkLogin(actionEvent);
    }

    private void checkLogin(ActionEvent actionEvent) {
        Main main = new Main();

        if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin")) {
            try {
                main.changeScene("luxurycamp.fxml", "Luxury Camp", actionEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            wrongLogin.setText("Wrong username or password");
        }
    }
}
