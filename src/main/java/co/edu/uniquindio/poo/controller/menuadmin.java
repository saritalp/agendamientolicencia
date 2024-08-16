package co.edu.uniquindio.poo.controller;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class menuadmin {

    @FXML
    private Button Modificarbt;

    @FXML
    private Button eliminarbt;

    @FXML
    private TableColumn<?, ?> fechaadmintc;

    @FXML
    private DatePicker fechadmindp;

    @FXML
    private TextField horatf;

    @FXML
    private TableColumn<?, ?> idadmintc;

    @FXML
    private TextField idadmintf;

    @FXML
    private TableColumn<?, ?> lugaradmintc;

    @FXML
    private TableColumn<?, ?> lugaradmintc1;

    @FXML
    private TextField lugaradmintf;

    @FXML
    private TableColumn<?, ?> nombreadmintc;

    @FXML
    private TextField nombreadmintf;

    @FXML
    private Button regresarbt;

    @FXML
    private TableView<?> tablaAdmin;

    @FXML
    private ComboBox<?> tipoadmincb;

    @FXML
    private TableColumn<?, ?> tipodmintc;

    @FXML
    void crearadmin(ActionEvent event) {

    }

    @FXML
    void eliminaradmi(ActionEvent event) {

    }

    @FXML
    void modificaradmin(ActionEvent event) {

    }

    @FXML
    void regresaradmin(ActionEvent event) {
        try {
            App.setRoot("menuprincipal");
        } catch (IOException e) {
            e.printStackTrace();
        }

}}