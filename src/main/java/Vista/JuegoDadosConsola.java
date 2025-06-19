package Vista;

import Modelo.JuegoDados;

import java.util.Scanner;

public class JuegoDadosConsola {
    private final Scanner scanner = new Scanner(System.in);
    private final JuegoDados juego = new JuegoDados();

    public void menu() {
        String opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            System.out.print("Seleccione opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> jugar();
                case "2" -> salir();
                default -> System.out.println("Opción inválida.");
            }
        } while (!opcion.equals("2"));
    }

    private void jugar() {
        int[] resultado = juego.jugar();
        System.out.println("Dado 1: " + resultado[0]);
        System.out.println("Dado 2: " + resultado[1]);
        System.out.println("Suma: " + resultado[2]);
        System.out.println(juego.gano(resultado[2]) ? "¡Ganaste!" : "Perdiste.");
    }

    private void salir() {
        System.out.print("¿Está seguro que desea salir? (S/N): ");
        String confirmacion = scanner.nextLine();
        if (!confirmacion.equalsIgnoreCase("S")) {
            menu();
        }
    }
}

