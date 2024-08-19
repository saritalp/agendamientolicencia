package co.edu.uniquindio.poo.controller;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Cita;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class solicituddecita implements Initializable{

    @FXML
    private TableColumn<Cita, String> IDcol;

    @FXML
    private TextField IDtf, telefonotf, nombretf, correotf;

    @FXML
    private Button agendarbt,regresarbt;



    @FXML
    private TableColumn<Cita, String> fechacol,horacol,lugarcol,tipocol ;
 

    @FXML
    private TableView<Cita> tablacliente;



    @FXML
    void agendaraction(ActionEvent event) {
        if (tablacliente.getSelectionModel().getSelectedItem() != null && !IDtf.getText().isEmpty()  && !telefonotf.getText().isEmpty() && !nombretf.getText().isEmpty() && !correotf.getText().isEmpty() )  {
            Cita cita = tablacliente.getSelectionModel().getSelectedItem();
            ModelFactoryController.getInstance().agendarCita(cita);
            new Alert(Alert.AlertType.INFORMATION,"Se ha agendado su cita exitosamente").show();
            tablacliente.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().listarCitas()));
            tablacliente.refresh();
        } else {
            new Alert(AlertType.WARNING, "No se ha seleccionado ninguna cita").show();
        }
    }   
    

    @FXML
    void regresaraction(ActionEvent event) {
        try {
            App.setRoot("menuprincipal");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    tablacliente.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().listarCitas()));
    IDcol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getIDCita()));
    horacol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getHora()));
    fechacol.setCellValueFactory(celda -> new ReadOnlyStringWrapper(celda.getValue().getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    lugarcol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getLugar()));
    tipocol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getTipolicencia().getNombre()));   
    
   
    tablacliente.refresh();
        }

    }
