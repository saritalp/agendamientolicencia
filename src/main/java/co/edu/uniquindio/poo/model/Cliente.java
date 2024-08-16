package co.edu.uniquindio.poo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Usuario {
    private String contrasena;

    public Cliente(String ID, String nombre, String telefono, String correo, String contrasena) {
        super(ID, nombre, telefono, correo);
        this.contrasena = contrasena;
    }

    @Override
    public void displayUserInfo() {
        System.out.println("Cliente: " + getID() + ", nombre: " + getNombre());
    }

    


}
