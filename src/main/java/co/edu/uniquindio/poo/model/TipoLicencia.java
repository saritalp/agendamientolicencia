package co.edu.uniquindio.poo.model;

public enum TipoLicencia {
    MOTO ("Moto"), CARRO ("Carro"), COMPLETA ("Completa"),;
    
    private String nombre;

    public static TipoLicencia getTipoliscencia(String nombre) {
        for (TipoLicencia tipoliscencia : TipoLicencia.values()) {
            if (tipoliscencia.nombre.equals(nombre)) {
                return tipoliscencia;
            }
        }
        return null;
    }

    public static String [] getValueStrinds(){
        var values = TipoLicencia.values();
        String[] strings = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            strings[i] = values[i].getNombre();
        }
        return strings;
    }

   
    private TipoLicencia(String nombre){
        this.nombre = nombre;
    }
       

    public String getNombre() {
        return nombre;
    }
}
