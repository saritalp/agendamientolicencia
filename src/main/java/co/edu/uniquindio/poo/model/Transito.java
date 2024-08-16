package co.edu.uniquindio.poo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.poo.excepciones.InicioFallidoException;
import co.edu.uniquindio.poo.excepciones.NoVerificadoException;
import co.edu.uniquindio.poo.excepciones.ObjetoExistenteException;
import co.edu.uniquindio.poo.excepciones.ObjetoNoExistenteException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Transito implements Serializable {
    private static Transito instance = null;
    private List<Cita> citas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    private Transito(List<Cita> citas, List<Cliente> clientes) {
        this.citas = citas;
        this.clientes = clientes;
    }

    public Transito() {

    }

    public Transito getInstance() {
        if (instance == null) {
            instance = new Transito(citas, clientes);
        }
        return instance;
    }

    public void registrarNuevoCliente(Cliente cliente) throws ObjetoExistenteException {
        if (buscarClientePorID(cliente.getID()) != null) {
            throw new ObjetoExistenteException("El cliente ya está registrado.");
        }
        clientes.add(cliente);

    }

    public Cliente buscarClientePorID(String id) {

        return clientes.stream().filter((cliente) -> cliente.getID().equals(id)).findFirst().orElse(null);
    }

    public List<Cliente> getClientePorID(String ID) {
        return clientes.stream().filter((cliente) -> cliente.getID().equals(ID)).toList();

    }

    public void eliminarCliente(String id) {
        Cliente cliente = buscarClientePorID(id);
        if (cliente != null) {
            clientes.remove(cliente);
        }
    }

    // Iniciar Sesion

    public Usuario iniciarSesion(String ID, String contrasena) throws InicioFallidoException {
        if (esAdministrador(ID, contrasena)) {
            return Administrador.obtenerInstancia();
        }else{
            throw new InicioFallidoException("Credenciales no proporcionadas");
        }
    }          

    private boolean esAdministrador(String ID, String contrasena) {
        Administrador administrador = Administrador.obtenerInstancia();
        return ID.equals(administrador.getID()) && contrasena.equals(administrador.getContrasena());
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public Cita crearCita(String tipoLicencia) throws ObjetoNoExistenteException {
        switch (tipoLicencia) {
            case "Moto":
                return new MotoFactory().crearCita();
            case "Carro":
                return new CarroFactory().crearCita();
            case "Completa":
                return new CompletaFactory().crearCita();
            default:
                throw new ObjetoNoExistenteException("Tipo de licencia desconocida: " + tipoLicencia);
        }
    }

    public void crearCita(Cita cita) throws ObjetoExistenteException {

        if (!buscarCitaPorId(cita.getIDCita())) {
            citas.add(cita);
        } else {
            throw new ObjetoExistenteException("La cita ya está registrada.");
        }

    }

    public void actualizarCliente(Cliente cliente) {
        int index = clientes.indexOf(clientes.stream()
                .filter((cli) -> cli.getID().equals(cliente.getID())).findFirst().orElse(null));
        if (index != -1) {
            clientes.set(index, cliente);
        }

    }

    public List<Cita> listarCitas() {
        return citas;
    }

    public boolean eliminarCitas(String IDCita) {

        // Utilizar removeIf para eliminar la cita con el ID especificado
        return citas.removeIf(cita -> cita.getIDCita().equals(IDCita));

    }

    public boolean buscarCitaPorId(String IDCita) {
        for (Cita cita : citas) {
            if (cita.getIDCita().equals(IDCita)) {
                return true;
            }
        }
        return false;
    }

    public void modificarCIta(String IDCita, Cita citaModificada) throws ObjetoNoExistenteException {

        for (Cita citaExistente : citas) {
            if (citaExistente.getIDCita().equals(IDCita)) {
                citaExistente.setLugar(citaModificada.getLugar());
                citaExistente.setIDCita(citaModificada.getIDCita());
                citaExistente.setHora(citaModificada.getHora());
                citaExistente.setFecha(citaModificada.getFecha());
                citaExistente.setTipolicencia(null);
                return;
            }
        }

        throw new ObjetoNoExistenteException("El evento no fue encontrado");
    }

}