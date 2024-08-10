package co.edu.uniquindio.poo.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Cita implements Serializable {
    private String lugar; 
    private String IDCita;
    private String hora;
    private LocalDate fecha;
    private TipoLicencia tipolicencia;
    
        
}
