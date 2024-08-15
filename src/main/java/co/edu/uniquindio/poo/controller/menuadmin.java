
package co.edu.uniquindio.poo.controller;

import java.io.IOException;


import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.excepciones.ObjetoExistenteException;
import co.edu.uniquindio.poo.model.Cita;
import co.edu.uniquindio.poo.model.TipoLicencia;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private TableColumn<Cita, String> fechaadmintc, idadmintc, lugaradmintc, nombreadmintc, nombreadmintf, topiadmintc;

    @FXML
    private DatePicker fechadmindp;

    @FXML
    private TextField idadmintf;

    @FXML
    private TextField lugaradmintf;

    @FXML
    private Button regresarbt;

    @FXML
    private TextField horatf;

    @FXML
    private ComboBox<TipoLicencia> tipoadmincb;

    @FXML
    private TableView<Cita> tablaAdmin;

    

    @FXML
    void crearadmin(ActionEvent event) throws ObjetoExistenteException {
        ModelFactoryController.getInstance().crearCita(idadmintf.getText(), horatf.getText(),lugaradmintf.getText(),nombreadmintf.getText(),fechadmindp.getValue(),tipoadmincb.getSelectionModel());
                     
;   }

    
    @FXML
    void eliminaradmi(ActionEvent event) {
        Cita cita=tablaAdmin.getSelectionModel().getSelectedItem();
        if (cita==null){
            new Alert(AlertType.ERROR, "Debe seleccionar una cita").show();
            return;
        }

        if(ModelFactoryController.getInstance().eliminarCitas(cita.getIDCita())==true) {
            new Alert(AlertType.INFORMATION, "Cita eliminada con exito").show();
            tablaAdmin.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().listarCitas())); 
        } else {
            new Alert(AlertType.ERROR, "No se pudo eliminar la cita").show();

        
        tablaAdmin.refresh();

        }
     
    }


    @FXML
    void modificaradmin(ActionEvent event) {

    }

    @FXML
    void regresaradmin(ActionEvent event) throws IOException {
             App.setRoot("menuprincipal");
}
       

}
