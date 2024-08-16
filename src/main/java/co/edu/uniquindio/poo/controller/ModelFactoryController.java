package co.edu.uniquindio.poo.controller;

import java.time.LocalDate;
import java.util.List;

import co.edu.uniquindio.poo.excepciones.InicioFallidoException;
import co.edu.uniquindio.poo.excepciones.NoVerificadoException;
import co.edu.uniquindio.poo.excepciones.ObjetoExistenteException;
import co.edu.uniquindio.poo.excepciones.ObjetoNoExistenteException;
import co.edu.uniquindio.poo.model.Cita;
import co.edu.uniquindio.poo.model.TipoLicencia;
import co.edu.uniquindio.poo.model.Transito;
import co.edu.uniquindio.poo.model.Usuario;
import co.edu.uniquindio.poo.utils.Serializacion;
import javafx.scene.control.SingleSelectionModel;


public class ModelFactoryController {

    private static ModelFactoryController instance;

    public static ModelFactoryController getInstance() {
        if (instance == null) {
            instance = new ModelFactoryController();
        }
        return instance;
    }

   
        
    public void crearCita(String IDCita, String hora, String lugar, String nombre, LocalDate fecha,
            SingleSelectionModel<TipoLicencia> tipolicencia) throws ObjetoExistenteException {
            Transito transito = Serializacion.obtenerDatos();
            Cita c= Cita.builder().IDCita(IDCita).hora(hora).lugar(lugar).nombre(nombre).fecha(fecha).tipolicencia(null).build();
            transito.crearCita(c);
                         
        Serializacion.guardarDatos(transito);
        
    }

    public void modificarCIta(String IDCita, String hora, String lugar, String nombre, LocalDate fecha,
    SingleSelectionModel<TipoLicencia> tipolicencia) throws ObjetoExistenteException, ObjetoNoExistenteException {
    Transito transito = Serializacion.obtenerDatos();
    Cita c= Cita.builder().IDCita(IDCita).hora(hora).lugar(lugar).nombre(nombre).fecha(fecha).tipolicencia(null).build();
    transito.modificarCIta(IDCita, c);
                 
    Serializacion.guardarDatos(transito);

}


public boolean eliminarCitas(String idCita) {
    Transito transito = Serializacion.obtenerDatos();
    boolean sePudoEliminar = transito.eliminarCitas(idCita);
    
    Serializacion.guardarDatos(transito);
    return sePudoEliminar;
 }

public List<Cita> listarCitas() {
     Transito transito = Serializacion.obtenerDatos();
     return transito.listarCitas();    
}



public Usuario iniciarSesion(String ID, String contrasena) throws InicioFallidoException, NoVerificadoException {
    Transito transito= Serializacion.obtenerDatos();
    return transito.iniciarSesion(ID, contrasena);
}
 




}