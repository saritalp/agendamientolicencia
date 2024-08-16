package co.edu.uniquindio.poo.controller;

import java.util.function.Consumer;

import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Usuario;
import javafx.beans.property.SimpleObjectProperty;

import lombok.Setter;
@Setter

public class datosguardados {
     
    private static datosguardados instance;
    private SimpleObjectProperty<Usuario> usuarioActual = new SimpleObjectProperty<>();// Nos deja cambiar la info del usuario

    public static datosguardados getInstance() {
        if (instance == null) {
            instance = new datosguardados();
        }
        return instance;
    }
    public void setUsuarioActual(Usuario usuarioActual){
        this.usuarioActual.set(usuarioActual);
    }

    public void addListener(Consumer<Usuario> listener){
        usuarioActual.addListener((observable, oldValue, newValue) -> {
           listener.accept(newValue);
        });
    }

    public boolean verificarIsAdmi (){
        return usuarioActual.getValue() instanceof Administrador;
    }

}


