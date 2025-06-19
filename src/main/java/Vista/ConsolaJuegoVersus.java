package Vista;

import Controlador.JuegoVersus;
import Modelo.*;

import java.util.Scanner;

public class ConsolaJuegoVersus {
    private final Scanner scanner = new Scanner(System.in);
    private Jugador j1;
    private Jugador j2;
    private JuegoVersus juego;

    public void menu() {
        System.out.print("Nombre jugador 1: ");
        j1 = new Jugador(scanner.nextLine());
        System.out.print("Nombre jugador 2: ");
        j2 = new Jugador(scanner.nextLine());

        juego = new JuegoVersus(j1, j2);

        System.out.print("¿Al mejor de cuántos intentos? (1 / 3 / 5): ");
        int rondas = Integer.parseInt(scanner.nextLine());

        int turno = 1;
        while (j1.getPuntos() <= rondas / 2 && j2.getPuntos() <= rondas / 2) {
            System.out.println("\n--- RONDA " + turno + " ---");

            jugarTurno(j1);
            jugarTurno(j2);

            System.out.printf("Marcador: %s [%d] - %s [%d]\n",
                    j1.getNombre(), j1.getPuntos(),
                    j2.getNombre(), j2.getPuntos());

            turno++;
        }

        Jugador ganador = juego.getGanador();
        System.out.println("\n🏆 ¡Ganador: " + ganador.getNombre() + "!");
        preguntarReinicio();
    }

    private void jugarTurno(Jugador jugador) {
        System.out.println(jugador.getNombre() + " lanza los dados...");
        int[] resultado = juego.turno(jugador);
        System.out.println("Dados: " + resultado[0] + ", " + resultado[1] + " → Suma: " + resultado[2]);
        if (resultado[2] == 7) System.out.println("¡Punto para " + jugador.getNombre() + "!");
    }

    private void preguntarReinicio() {
        System.out.print("\n¿Desean jugar otra vez? (S/N): ");
        if (scanner.nextLine().equalsIgnoreCase("S")) {
            juego.reiniciar();
            menu();
        } else {
            System.out.println("Juego terminado.");
        }
    }
}

