package org.example;

import java.util.Scanner;

public class ColaFallidos {
    private Vuelo inicio, fin;
    
    public ColaFallidos() {
        this.inicio = null;
        this.fin = null;
    }
    
    public void agregarVuelo(Vuelo vuelo) {
        if (fin == null) {
            inicio = vuelo;
            fin = vuelo;
        } else {
            fin.setSiguiente(vuelo);
            fin = vuelo;
        }
    }
    
    public Vuelo procesarVuelo() {
        if (inicio == null) {
            return null;
        }
        Vuelo procesado = inicio;
        inicio = inicio.getSiguiente();
        if (inicio == null) {
            fin = null;
        }
        procesado.setSiguiente(null);
        return procesado;
    }
    
    public void procesarVueloFallido() {
        Scanner scanner = new Scanner(System.in);
        Vuelo vuelo;
        if (inicio == null){
            System.out.println("\nNo hay vuelos fallidos para procesar\n");
        } else {
            while ((vuelo = procesarVuelo()) != null) {
                System.out.println("\nVuelo siguiente en la cola:\n" +
                        "\n  Numero de vuelo: " + vuelo.getNumeroMision() +
                        "\n  Nombre de vuelo: " + vuelo.getNombre() +
                        "\n  Fecha de vuelo: " + vuelo.getFecha() +
                        "\n  PLaca de nave: " + vuelo.getNombre() +
                        "\n  Id de director: " + vuelo.getIdDirector());
                
                System.out.print("¿Desea eliminar este vuelo? (s/n): ");
                String opcion = scanner.nextLine().toLowerCase();
                
                if (opcion.equals("s")) {
                    System.out.println("Vuelo eliminado.");
                } else {
                    agregarVuelo(vuelo);
                    System.out.println("Vuelo mantenido en la cola.");
                }
                
                System.out.println("\n Escriba 'salir' para terminar el procesamiento de vuelos fallidos" +
                                   "\n o cualquier otra palabra para continuar");
                String continuar = scanner.nextLine().toLowerCase();
                
                if(continuar.equalsIgnoreCase("salir")){
                    break;
                }
                
                if (inicio == null) {
                    System.out.println("\nAhora la cola de vuelos fallidos está vacía.");
                    break;
                }
            }
        }
    }
    
    public void consultarVuelosFallidos() {
        Vuelo actual = inicio;
        while (actual != null) {
            System.out.println("Numero de mision: " + actual.getNumeroMision() + "\nNombre: " + actual.getNombre() +
                    "\nFecha: " + actual.getFecha() + "\nId de director: " + actual.getIdDirector() +
                    "\nPlaca de nave: " + actual.getPlacaNave()
                    + "\n");
            actual = actual.getSiguiente();
        }
    }
}

