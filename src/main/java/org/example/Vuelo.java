package org.example;

public class Vuelo {
    private int numeroMision;
    private String nombre, fecha, idDirector, placaNave;
    private Vuelo anterior, siguiente;
    
    public Vuelo(int numeroMision, String nombre, String fecha, String idDirector, String placaNave) {
        setNumeroMision(numeroMision);
        setNombre(nombre);
        setFecha(fecha);
        setIdDirector(idDirector);
        setPlacaNave(placaNave);
        setAnterior(null);
        setSiguiente(null);
    }
    
    public Vuelo(int numeroMision, String nombre, String fecha, String idDirector, String placaNave, Vuelo anterior) {
        setNumeroMision(numeroMision);
        setNombre(nombre);
        setFecha(fecha);
        setIdDirector(idDirector);
        setPlacaNave(placaNave);
        setAnterior(anterior);
        setSiguiente(null);
    }
    
    public Vuelo(int numeroMision, String nombre, String fecha, String idDirector, String placaNave, Vuelo anterior, Vuelo siguiente) {
        setNumeroMision(numeroMision);
        setNombre(nombre);
        setFecha(fecha);
        setIdDirector(idDirector);
        setPlacaNave(placaNave);
        setAnterior(anterior);
        setSiguiente(siguiente);
    }
    
    public int getNumeroMision() {
        return numeroMision;
    }
    
    public void setNumeroMision(int numeroMision) {
        this.numeroMision = numeroMision;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getIdDirector() {
        return idDirector;
    }
    
    public void setIdDirector(String idDirector) {
        this.idDirector = idDirector;
    }
    
    public String getPlacaNave() {
        return placaNave;
    }
    
    public void setPlacaNave(String placaNave) {
        this.placaNave = placaNave;
    }
    
    public Vuelo getAnterior() {
        return anterior;
    }
    
    public void setAnterior(Vuelo anterior) {
        this.anterior = anterior;
    }
    
    public Vuelo getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(Vuelo siguiente) {
        this.siguiente = siguiente;
    }
}
