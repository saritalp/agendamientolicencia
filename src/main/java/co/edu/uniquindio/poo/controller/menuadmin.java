package co.edu.uniquindio.poo.controller;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.excepciones.ObjetoExistenteException;
import co.edu.uniquindio.poo.excepciones.ObjetoNoExistenteException;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import co.edu.uniquindio.poo.model.Cita;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class menuadmin implements Initializable {

    @FXML
    private Button Modificarbt,eliminarb,regresarbt;

    @FXML
    private DatePicker fechadmindp;

    @FXML
    private TextField horatf,idadmintf,nombreadmintf,lugaradmintf;

    @FXML
    private TableColumn <Cita, String> idadmintc, lugaradmintc,horatc,nombreadmintc, tipodmintc,fechaadmintc;


    @FXML
    private TableView<Cita> tablaAdmin;

    @FXML
    private ComboBox<String> tipoadmincb;

    

    @FXML
    void crearadmin(ActionEvent event) {
        try{
            ModelFactoryController.getInstance().crearCita(idadmintf.getText(),horatf.getText(), lugaradmintf.getText(),  nombreadmintf.getText(), fechadmindp.getValue(), tipoadmincb.getValue());
            new Alert(AlertType.INFORMATION, "Cita crea con exito").show();
            tablaAdmin.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance(). listarCitas()));
            tablaAdmin.refresh();

        } catch (ObjetoExistenteException e) {
            new Alert(AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void eliminaradmi(ActionEvent event) {
    Cita cita = (Cita) tablaAdmin.getSelectionModel().getSelectedItem();;
        if(cita==null){
            new Alert(AlertType.ERROR,"Debe seleccionar").show();
            return;
        }
        if(ModelFactoryController.getInstance().eliminarCitas(cita.getIDCita())==true){
            new Alert(AlertType.INFORMATION,"Cita eliminada").show();
            if(tipoadmincb.getValue()!=null){
                tablaAdmin.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().listarCitas()));
        }
        tipoadmincb.setValue(null);
        tablaAdmin.refresh();
    }
    }

    @FXML
    void modificaradmin(ActionEvent event) throws ObjetoNoExistenteException {
        Cita cita = (Cita) tablaAdmin.getSelectionModel().getSelectedItem();
        if(cita==null){
            new Alert(AlertType.ERROR,"Debe seleccionar").show();
            return;
        }
        try{
            ModelFactoryController.getInstance().modificarCIta(cita.getIDCita(), horatf.getText(), lugaradmintf.getText(),  nombreadmintf.getText(), fechadmindp.getValue(), tipoadmincb.getValue());
            new Alert(AlertType.INFORMATION, "Cita modificada con exito").show();
            tablaAdmin.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().listarCitas()));
            tablaAdmin.refresh();
        } catch (ObjetoExistenteException e) {
            new Alert(AlertType.ERROR, e.getMessage()).show();
    
    
    }
    }
    @FXML
    void regresaradmin(ActionEvent event) {
        try {
            App.setRoot("menuprincipal");
        } catch (IOException e) {
            e.printStackTrace();
        }

}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
    tipoadmincb.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().obtenerTipo()));
    
    tablaAdmin.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, cita) -> {
        if(cita != null) {
            nombreadmintf.setText(cita.getNombre());
            idadmintf.setText(cita.getIDCita());
            lugaradmintf.setText(cita.getLugar());
            horatf.setText(cita.getHora());
            fechadmindp.setValue(cita.getFecha());
            tipoadmincb.setValue(cita.getTipolicencia().getNombre()); 
        }
    });
    tablaAdmin.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().listarCitas()));
    idadmintc.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getIDCita()));
    horatc.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getHora()));
    fechaadmintc.setCellValueFactory(celda -> new ReadOnlyStringWrapper(celda.getValue().getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    nombreadmintc.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNombre()));
    lugaradmintc.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getLugar()));
    tipodmintc.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getTipolicencia().getNombre()));   
    tipoadmincb.valueProperty().addListener((observable, oldValue, newValue) -> {
    tablaAdmin.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().listarCitas()));
    tablaAdmin.refresh();
        });


}
}
