package Vista;

import Modelo.Jugador;
import Modelo.ResultadoRonda;
import Modelo.TipoSet;
import Controlador.JuegoVersusControlador;

import java.util.Scanner;

public class ConsolaJuegoVersus {
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        System.out.println("\n--- JUEGO VERSUS ---");
        System.out.print("Nombre del Jugador 1: ");
        Jugador jugador1 = new Jugador(scanner.nextLine());

        System.out.print("Nombre del Jugador 2: ");
        Jugador jugador2 = new Jugador(scanner.nextLine());

        TipoSet tipoSet = seleccionarTipoSet();

        JuegoVersusControlador juego = new JuegoVersusControlador(jugador1, jugador2, tipoSet);

        while (!juego.isSetTerminado()) {
            ResultadoRonda resultado = juego.jugarRonda();
            mostrarResultadoRonda(resultado);
            mostrarMarcador(juego);
        }

        mostrarGanador(juego.getGanadorSet());
        preguntarReinicio();
    }

    private TipoSet seleccionarTipoSet() {
        System.out.println("Seleccione modalidad:");
        System.out.println("1. Mejor de 1");
        System.out.println("2. Mejor de 3");
        System.out.println("3. Mejor de 5");
        System.out.print("Opción: ");
        return switch (scanner.nextLine()) {
            case "1" -> TipoSet.MEJOR_DE_1;
            case "2" -> TipoSet.MEJOR_DE_3;
            case "3" -> TipoSet.MEJOR_DE_5;
            default -> {
                System.out.println("Opción inválida. Por defecto: Mejor de 1");
                yield TipoSet.MEJOR_DE_1;
            }
        };
    }

    private void mostrarResultadoRonda(ResultadoRonda r) {
        System.out.println("\n RONDA " + r.getNumeroRonda());

        System.out.printf("🎲 %s → %d + %d = %d → %s\n",
                r.getNombreJugador1(), r.getCaraDado1J1(), r.getCaraDado2J1(), r.getSumaJ1(),
                r.isGanoJ1Ronda() ? " Punto" : " Sin punto");

        System.out.printf("🎲 %s → %d + %d = %d → %s\n",
                r.getNombreJugador2(), r.getCaraDado1J2(), r.getCaraDado2J2(), r.getSumaJ2(),
                r.isGanoJ2Ronda() ? " Punto" : " Sin punto");
    }

    private void mostrarMarcador(JuegoVersusControlador juego) {
        System.out.printf(" Marcador: %s [%d] - %s [%d]\n",
                juego.getJugador1().getNombre(), juego.getVictoriasJugador1(),
                juego.getJugador2().getNombre(), juego.getVictoriasJugador2());
    }

    private void mostrarGanador(Jugador ganador) {
        if (ganador != null) {
            System.out.println("\n ¡Ganador del set: " + ganador.getNombre() + "!");
        } else {
            System.out.println("\n No hay ganador definido.");
        }
    }

    private void preguntarReinicio() {
        System.out.print("\n¿Desean jugar otra vez? (S/N): ");
        if (scanner.nextLine().equalsIgnoreCase("S")) {
            menu();
        } else {
            System.out.println("Gracias por jugar.");
        }
    }
}
