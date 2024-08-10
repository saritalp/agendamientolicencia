package co.edu.uniquindio.poo.model;

public class CompletaFactory implements LicenciaFactory {
    @Override
public Cita crearCita() {
    return new Cita();
}
}

