package org.example;

public class Nave {
    private String placa, nombre, tipo;
    
    public Nave(String placa, String nombre, String tipo) {
        setPlaca(placa);
        setNombre(nombre);
        setTipo(tipo);
    }
    
    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
