package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayObjBDnave {
    private ArrayList<Nave> naves;
    
    public ArrayObjBDnave() {
        this.naves = new ArrayList<>();
    }
    
    public void agregarNave() {
        Scanner scanner = new Scanner(System.in);
        boolean seguir = true;
        
        while (seguir) {
            System.out.println("Ingresar información de la nave:");
            System.out.print("\n  Placa: ");
            String placa = scanner.nextLine();
            if (buscarNave(placa) != null) {
                System.out.println("\nError: ya existe una nave con esa placa");
            } else {
                System.out.print("  Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("  Tipo: ");
                String tipo = scanner.nextLine();
                
                Nave nuevaNave = new Nave(placa, nombre, tipo);
                naves.add(nuevaNave);
                System.out.println("\nNave agregada exitosamente.\n");
            }
            
            System.out.print("¿Desea agregar otra nave? (s/n): ");
            seguir = scanner.nextLine().equalsIgnoreCase("s");
        }
    }
    
    public Nave buscarNave(String placa) {
        for (Nave nave : naves) {
            if (nave.getPlaca().equals(placa)) {
                return nave;
            }
        }
        return null;
    }
}

