package Launcher;

import Vista.JuegoDadosConsola;
import Vista.ConsolaJuegoVersus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n--- JUEGO DE DADOS ---");
            System.out.println("1. Juego individual");
            System.out.println("2. Juego versus");
            System.out.println("3. Salir");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> new JuegoDadosConsola().menu();
                case "2" -> new ConsolaJuegoVersus().menu();
                case "3" -> {
                    System.out.print("¿Está seguro que desea salir? (S/N): ");
                    if (sc.nextLine().equalsIgnoreCase("S")) {
                        System.out.println("¡Hasta luego!");
                        return;
                    }
                }
                default -> System.out.println("Opción no válida.");
            }
        } while (true);
    }
}

