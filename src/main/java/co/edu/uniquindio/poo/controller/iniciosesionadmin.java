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
    void ingresaraction(ActionEvent event) throws IOException, NoVerificadoException, InicioFallidoException {
        try {
            // Intenta iniciar sesión con el usuario y contraseña proporcionados
            Usuario usuario = ModelFactoryController.getInstance().iniciarSesion(USUARIOTF.getText(), CONTRASENAPF.getText());
            
            // Establece el usuario actual
            datosguardados.getInstance().setUsuarioActual(usuario);
        
            // Verifica si el usuario es un Administrador y cambia la vista
            if (datosguardados.getInstance().verificarIsAdmi()) {
                App.setRoot("menuadmin");
            } else {
                new Alert(AlertType.WARNING, "No eres administrador").show();
            }
        } catch (InicioFallidoException e) {
            // Muestra un mensaje de advertencia en caso de fallo en el inicio de sesión
            new Alert(AlertType.WARNING, e.getMessage()).show();
        } catch (Exception e) {
            // Muestra un mensaje de error en caso de una excepción inesperada
            new Alert(AlertType.ERROR, "Ocurrió un error inesperado. Inténtalo nuevamente.").show();
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
