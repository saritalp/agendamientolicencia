package co.edu.uniquindio.poo.controller;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class menuprincipal {

    @FXML
    private Button ADMINBT, CCLIENTEBT;

    @FXML
    void adminaction(ActionEvent event) throws IOException {
        try {
            App.setRoot("iniciosesionadmin");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void clienteaction(ActionEvent event) {
        try {
            App.setRoot("solicituddecita");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
