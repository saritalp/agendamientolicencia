package co.edu.uniquindio.poo.model;

public class CarroFactory implements LicenciaFactory{
    @Override
    public Cita crearCita() {
        return new Cita();
    }   
}