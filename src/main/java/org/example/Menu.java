package org.example;

import java.util.Scanner;

public class Menu {
    private ListaOriginal listaVuelos = new ListaOriginal();
    private PilaFallidos pilaFallidos;
    private ColaFallidos colaFallidos;
    private ArrayObjBDnave naves = new ArrayObjBDnave();
    private ArrayObjDBdirectores directores = new ArrayObjDBdirectores();
    private boolean usarPila = true;
    
    public Menu(){
        elegirEstructuraAlmacenamiento();
        mostrarMenu();
    }
    
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        
        while (!salir) {
            System.out.print(
                    "-------------------------------------------------------------" +
                            "\n  Menú principal\n\n" +
                            "  Agregar naves ---- 1\n" +
                            "  Agregar director@s ---- 2\n" +
                            "  Agregar vuelos o misión ---- 3\n" +
                            "  Consultar un vuelo o misión ---- 4\n" +
                            "  Consultar todos los vuelos de la lista original ---- 5\n" +
                            "  Marcar vuelos fallidos ---- 6\n" +
                            "  Consultar todos los vuelos fallidos ---- 7\n" +
                            "  Procesar vuelo fallidos ---- 8\n" +
                            "  Salir ---- 0\n" +
                            "-------------------------------------------------------------"+
                            "\nSeleccione una opción: "
            );
            int opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("-------------------------------------------------------------");
            
            switch (opcion) {
                case 1:
                    naves.agregarNave();
                    break;
                case 2:
                    directores.agregarDirector();
                    break;
                case 3:
                    listaVuelos.agregarVuelo(naves, directores);
                    break;
                case 4:
                    listaVuelos.consultarVuelo();
                    break;
                case 5:
                    listaVuelos.consultarTodosLosVuelos();
                    break;
                case 6:
                    listaVuelos.marcarVuelosFallidos(usarPila, colaFallidos, pilaFallidos);
                    break;
                case 7:
                    if (usarPila){
                        pilaFallidos.consultarVuelosFallidos();
                    } else {
                        colaFallidos.consultarVuelosFallidos();
                    }
                    break;
                case 8:
                    if (usarPila){
                        pilaFallidos.procesarVueloFallido();
                    } else {
                        colaFallidos.procesarVueloFallido();
                    }
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    mostrarMenu();
                    break;
            }
        }
    }
    
    private void elegirEstructuraAlmacenamiento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n------- Sistema para gestion de vuelos espaciales -------\n" +
                           "\nElija la estructura de almacenamiento para vuelos fallidos: " +
                           "\n  Pila --- 1" +
                           "\n  Cola ---2" +
                           "\nOpcion: ");
        int opcion = scanner.nextInt();
        System.out.println("--------------------------------------------------");
        scanner.nextLine();
        
        if (opcion != 1 && opcion != 2) {
            System.out.println("Opción no válida\n");
            elegirEstructuraAlmacenamiento();
        } else if (opcion == 1) {
            usarPila = true;
            pilaFallidos = new PilaFallidos();
            System.out.println("\nSe eligio una pila para almacenar vuelos fallidos\n");
        } else if (opcion == 2) {
            usarPila = false;
            colaFallidos = new ColaFallidos();
            System.out.println("\nSe eligio una cola para almacenar vuelos fallidos\n");
        }
    }
}

