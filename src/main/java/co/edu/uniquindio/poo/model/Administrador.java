package co.edu.uniquindio.poo.model;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter
public class Administrador extends Usuario {
    
    private final String ID = "AdminTransito";
    private final String contrasena = "123";
    private static Administrador instancia;

    public Administrador(String ID, String nombre, String telefono, String correo) {
        super(ID, nombre, telefono, correo);
    }
    
    public static Administrador obtenerInstancia() {
        
        if (instancia == null) {
           instancia = new Administrador(null, null, null, null);
        }
        
        return instancia;
    }

    @Override
    public void displayUserInfo() {
        
    }
}

