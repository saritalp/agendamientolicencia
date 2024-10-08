package co.edu.uniquindio.poo.controller;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.excepciones.InicioFallidoException;
import co.edu.uniquindio.poo.excepciones.NoVerificadoException;

import co.edu.uniquindio.poo.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class iniciosesionadmin {

    @FXML
    private PasswordField CONTRASENAPF;

    @FXML
    private Button INGRESARBT;

    @FXML
    private Button REGRESARBT1;
    @FXML
    private TextField USUARIOTF;

    @FXML
    void ingresaraction(ActionEvent event) throws IOException{
        try {
          
            Usuario usuario = ModelFactoryController.getInstance().iniciarSesion(USUARIOTF.getText(), CONTRASENAPF.getText());
            
            datosguardados.getInstance().setUsuarioActual(usuario);
        
            
            if (datosguardados.getInstance().verificarIsAdmi()) {
                App.setRoot("menuadmin");
            } else {
                new Alert(AlertType.WARNING, "No eres administrador").show();
            }
        } catch (InicioFallidoException e) {
       
           new Alert(AlertType.WARNING, "ERROR").show();
        } catch (NoVerificadoException e) {
            new Alert(AlertType.WARNING, "ERROR 2").show();
    
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

}
