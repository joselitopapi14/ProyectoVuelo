package org.example;

import java.util.Scanner;

public class ListaOriginal {
    private Vuelo inicio, fin;
    
    public ListaOriginal() {
        this.inicio = null;
        this.fin = null;
    }
    
    public Vuelo getInicio() {
        return inicio;
    }
    
    public Vuelo getFin() {
        return fin;
    }
    
    public void agregarVuelo(ArrayObjBDnave naves, ArrayObjDBdirectores directores) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar información de vuelos o misiones:");
        boolean continuar = true;
        
        while (continuar) {
            System.out.print("\n  Número de misión: ");
            int numeroMision = Integer.parseInt(scanner.nextLine());
            
            if (consultarVueloAux(numeroMision) != null){
                System.out.print("\nError: el numero de vuelo ya existe\n");
            } else {
                System.out.print("  Nombre de vuelo: ");
                String nombre = scanner.nextLine();
                
                System.out.print("  Fecha: ");
                String fecha = scanner.nextLine();
                
                System.out.print("  Identificador de director(a): ");
                String idDirector = scanner.nextLine();
                
                System.out.print("  Placa de la nave: ");
                String placaNave = scanner.nextLine();
                
                if (directores.buscarDirector(idDirector) != null && naves.buscarNave(placaNave) != null) {
                    Vuelo nuevoVuelo = new Vuelo(numeroMision, nombre, fecha, idDirector, placaNave);
                    agregarVueloOrdenado(nuevoVuelo);
                    System.out.println("Vuelo agregado exitosamente: ");
                } else {
                    System.out.println("Error: La identificación del director o la placa de la nave no existe.");
                }
            }
            
            System.out.print("\n¿Desea agregar otro vuelo o misión? (s/n): ");
            continuar = scanner.nextLine().equalsIgnoreCase("s");
        }
    }
    
    private void agregarVueloOrdenado(Vuelo nuevoVuelo) {
        if (inicio == null) {
            inicio = nuevoVuelo;
            fin = nuevoVuelo;
        } else {
            Vuelo nodoActual = inicio;
            while (nodoActual != null && nodoActual.getNumeroMision() < nuevoVuelo.getNumeroMision()) {
                nodoActual = nodoActual.getSiguiente();
            }
            if (nodoActual == inicio) {
                nuevoVuelo.setSiguiente(inicio);
                inicio.setAnterior(nuevoVuelo);
                inicio = nuevoVuelo;
            } else if (nodoActual == null) {
                fin.setSiguiente(nuevoVuelo);
                nuevoVuelo.setAnterior(fin);
                fin = nuevoVuelo;
            } else {
                nuevoVuelo.setSiguiente(nodoActual);
                nuevoVuelo.setAnterior(nodoActual.getAnterior());
                nodoActual.getAnterior().setSiguiente(nuevoVuelo);
                nodoActual.setAnterior(nuevoVuelo);
            }
        }
    }
    
    public void consultarVuelo() {
        Scanner scanner = new Scanner(System.in);
        boolean seguir = true;
        while (seguir) {
            System.out.print(" Ingrese el número de misión a consultar: ");
            int numeroMision = scanner.nextInt();
            scanner.nextLine();
            Vuelo vuelo = consultarVueloAux(numeroMision);
            if (vuelo != null) {
                System.out.println("  Vuelo encontrado: \n\n" + "Numero de mision: " + vuelo.getNumeroMision() + "\nNombre: " + vuelo.getNombre() +
                        "\nFecha: " + vuelo.getFecha() + "\nId de director: " + vuelo.getIdDirector() + "\nPlaca de nave: " + vuelo.getPlacaNave() + "\n");
            } else {
                System.out.println("  Vuelo no encontrado.");
            }
            System.out.print("¿Desea consultar otro vuelo? (s/n): ");
            seguir = scanner.nextLine().equalsIgnoreCase("s");
        }
    }
    
    private Vuelo consultarVueloAux(int numeroMision) {
        Vuelo nodoActual = inicio;
        while (nodoActual != null) {
            if (nodoActual.getNumeroMision() == numeroMision) {
                return nodoActual;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return null;
    }
    
    public void marcarVuelosFallidos(boolean usarPila, ColaFallidos colaFallidos, PilaFallidos pilaFallidos) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        while (continuar) {
            System.out.print("\n Ingrese el número de misión del vuelo fallido (o 'salir' para terminar): ");
            String entrada = scanner.nextLine();
            
            if (entrada.equalsIgnoreCase("salir")) {
                continuar = false;
            } else {
                try {
                    int numeroMision = Integer.parseInt(entrada);
                    Vuelo vueloFallido = marcarVueloFallidoPorNumero(numeroMision);
                    if (vueloFallido != null) {
                        if (usarPila) {
                            pilaFallidos.agregarVuelo(vueloFallido);
                        } else {
                            colaFallidos.agregarVuelo(vueloFallido);
                        }
                        System.out.println("Vuelo marcado como fallido\n");
                    } else {
                        System.out.println("Vuelo no encontrado.\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número de misión válido.\n");
                }
            }
        }
    }
    
    private Vuelo marcarVueloFallidoPorNumero(int numeroMision) {
        Vuelo nodoActual = inicio;
        while (nodoActual != null) {
            if (nodoActual.getNumeroMision() == numeroMision) {
                if (nodoActual == inicio) {
                    inicio = nodoActual.getSiguiente();
                    if (inicio != null){
                        inicio.setAnterior(null);
                    }
                } else {
                    nodoActual.getAnterior().setSiguiente(nodoActual.getSiguiente());
                }
                
                if (nodoActual == fin) {
                    fin = nodoActual.getAnterior();
                    if (fin != null) {
                        fin.setSiguiente(null);
                    }
                } else {
                    nodoActual.getSiguiente().setAnterior(nodoActual.getAnterior());
                }
                nodoActual.setAnterior(null);
                nodoActual.setSiguiente(null);
                return nodoActual;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return null;
    }
    
    public void consultarTodosLosVuelos() {
        Vuelo nodoActual = inicio;
        while (nodoActual != null) {
            System.out.println("Numero de mision: " + nodoActual.getNumeroMision() +
                               "\nNombre: " + nodoActual.getNombre() +
                               "\nFecha: " + nodoActual.getFecha() +
                               "\nId de director: " + nodoActual.getIdDirector() +
                               "\nPlaca de nave: " + nodoActual.getPlacaNave() +
                               "\n");
            nodoActual = nodoActual.getSiguiente();
        }
    }
}

