package co.edu.uniquindio.poo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.uniquindio.poo.model.Transito;

public class Serializacion {

    private static final String RUTA = "datos.dat";

    public static void guardarDatos(Transito transito) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA))) {
            oos.writeObject(transito);
            System.out.println("Guardado exitoso de datos");
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }

    
    public static Transito obtenerDatos() {
        Transito transito = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA))) {
            transito = (Transito) ois.readObject();
            System.out.println("Datos cargados exitosamente");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de datos");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        }

        
        if (transito == null) {
            transito = new Transito();
            guardarDatos(transito); 
        }
        return transito;
    }
}
