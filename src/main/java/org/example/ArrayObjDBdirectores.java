package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayObjDBdirectores {
    private ArrayList<Director> directores;
    
    public ArrayObjDBdirectores() {
        this.directores = new ArrayList<>();
    }
    
    public void agregarDirector() {
        Scanner scanner = new Scanner(System.in);
        boolean seguir = true;
        
        while (seguir) {
            System.out.println("Ingresar información de director:");
            System.out.print("\n  Identificación: ");
            String id = scanner.nextLine();
            if (buscarDirector(id) != null){
                System.out.print("\nError: ya existe un director con esta identificación\n");
            } else {
                System.out.print("  Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("  Apellido: ");
                String apellido = scanner.nextLine();
                
                Director nuevoDirector = new Director(id, nombre, apellido);
                directores.add(nuevoDirector);
                System.out.println("\nDirector agregado exitosamente.\n");
            }
           
            System.out.print("¿Desea agregar otro director? (s/n): ");
            seguir = scanner.nextLine().equalsIgnoreCase("s");
        }
    }
    
    public Director buscarDirector(String id) {
        for (Director director : directores) {
            if (director.getId().equals(id)) {
                return director;
            }
        }
        return null;
    }
}

