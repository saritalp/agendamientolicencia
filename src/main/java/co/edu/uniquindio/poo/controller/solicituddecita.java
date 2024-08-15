package co.edu.uniquindio.poo.controller;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Cita;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class solicituddecita {

    @FXML
    private TableColumn<Cita, String> IDcol;

    @FXML
    private TextField IDtf;

    @FXML
    private Button agendarbt;

    @FXML
    private PasswordField correotf;

    @FXML
    private TableColumn<Cita, String> fechacol;

    @FXML
    private TableColumn<Cita, String> horacol;

    @FXML
    private TableColumn<Cita, String> lugarcol;

    @FXML
    private PasswordField nombreTf;

    @FXML
    private Button regresarbt;

    @FXML
    private PasswordField telefonotf;

    @FXML
    private TableColumn<Cita, String> tipocol;

    @FXML
    void agendaraction(ActionEvent event) {

    }

    @FXML
    void regresaraction(ActionEvent event) {
        try {
            App.setRoot("menuprincipal");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
