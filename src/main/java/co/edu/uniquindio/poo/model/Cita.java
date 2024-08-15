package co.edu.uniquindio.poo.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class Cita implements Serializable {
    
    private String IDCita;
    private String hora;
    private String lugar;
    private String nombre;
    private LocalDate fecha;
    private TipoLicencia tipolicencia;
    
    public Cita() {}
        
}
