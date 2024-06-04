package org.example;

public class Director {
    private String id, nombre, apellido;
    
    public Director(String id, String nombre, String apellido) {
        setId(id);
        setNombre(nombre);
        setApellido(apellido);
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
