package co.edu.uniquindio.poo.controller;
import java.io.IOException;

import co.edu.uniquindio.poo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

public class menuprincipal {

    @FXML
    private Button ADMINBT;

    @FXML
    private Button CCLIENTEBT;

    @FXML
    void adminaction(ActionEvent event) {
         try {
            App.setRoot("iniciosesionadmin");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    
    @FXML
    void clienteaction(ActionEvent event) {
         try {
            App.setRoot("solicitudcita");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    }


