package co.edu.uniquindio.poo.model;

public class MotoFactory implements LicenciaFactory {
    @Override
    public Cita crearCita() {
        return new Cita();
    }

}
