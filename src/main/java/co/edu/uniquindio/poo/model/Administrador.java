package co.edu.uniquindio.poo.model;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter
@EqualsAndHashCode(callSuper=false)
public class Administrador extends Usuario  {
    
    private final String ID = "admin transito";
    private final String contrasena = "1234";
    private static Administrador instancia;

    public Administrador(String ID, String nombre, String telefono, String correo) {
        super(ID, nombre, telefono, correo);
    }

    public Administrador(){
        super("123", "Admin", "telefono", "correo");
    }
    
    public static Administrador obtenerInstancia() {
        
        if (instancia == null) {
            instancia = new Administrador();
        }
        
        return instancia;
    }

    @Override
    public void displayUserInfo() {
        
    }
}

