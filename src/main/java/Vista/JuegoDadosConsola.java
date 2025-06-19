package Vista;

import Controlador.JuegodeDados;
import java.util.Scanner;

public class JuegoDadosConsola {
    private final Scanner scanner = new Scanner(System.in);
    private final JuegodeDados juego = new JuegodeDados();

    public void menu() {
        String opcion;
        do {
            System.out.println("\n--- JUEGO INDIVIDUAL ---");
            System.out.println("1. Lanzar dados");
            System.out.println("2. Volver al menú principal");
            System.out.print("Seleccione opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> jugar();
                case "2" -> {
                    System.out.println("Regresando al menú principal...");
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        } while (true);
    }

    private void jugar() {
        int suma = juego.lanzarDadosYObtenerSuma();

        int dado1 = juego.getCaraDado1();
        int dado2 = juego.getCaraDado2();

        System.out.println("Dado 1: " + dado1);
        System.out.println("Dado 2: " + dado2);
        System.out.println("Suma: " + suma);

        if (juego.esVictoria(suma)) {
            System.out.println(" ¡Ganaste! ");
        } else {
            System.out.println(" Perdiste.");
        }
    }
}
