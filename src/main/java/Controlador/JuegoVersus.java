package Controlador;
import Modelo.Jugador;
import Modelo.Suma;
import Modelo.TipoSet;
public class JuegoVersusControlador {
    private Jugador jugador1;
    private Jugador jugador2;
    private int rondasActuales;
    private int victoriasJugador1;
    private int victoriasJugador2;


    public JuegoVersusControlador(Jugador jugador1, Jugador jugador2,TipoSet tipoSet) {
        this.jugador1 = jugador1; // recibe instancias de Jugador.
        this.jugador2 = jugador2; // recibe instancias de Jugador.
        this.rondasActuales = 0;      //  contador de rondas en cero.
        this.victoriasJugador1 = 0;   //  las victorias de ambos jugadores en cero.
        this.victoriasJugador2 = 0;

    }

    public ResultadoRonda jugarRonda() {
        rondasActuales++;

        int sumaJugador1 = controladorTurnoJ1.lanzarDadosYObtenerSuma();
        boolean ganoJugador1Ronda = controladorTurnoJ1.esVictoria(sumaJugador1);

        int sumaJugador2 = controladorTurnoJ2.lanzarDadosYObtenerSuma();
        boolean ganoJugador2Ronda = controladorTurnoJ2.esVictoria(sumaJugador2);

        if (ganoJugador1Ronda) {
            victoriasJugador1++;
        }
        if (ganoJugador2Ronda) {
            victoriasJugador2++;
        }

        return new ResultadoRonda(
                rondasActuales,
                jugador1.getNombre(), controladorTurnoJ1.getCaraDado1(), controladorTurnoJ1.getCaraDado2(), sumaJugador1, ganoJugador1Ronda,
                jugador2.getNombre(), controladorTurnoJ2.getCaraDado1(), controladorTurnoJ2.getCaraDado2(), sumaJugador2, ganoJugador2Ronda
        );
        public boolean isSetTerminado () {
            switch (tipoSet) {
                case MEJOR_DE_1:
                    // El set termina si cualquier jugador ha ganado al menos una ronda.
                    return victoriasJugador1 > 0 || victoriasJugador2 > 0;
                case MEJOR_DE_3:
                    // El set termina si algún jugador ha ganado 2 o más rondas.
                    return victoriasJugador1 >= 2 || victoriasJugador2 >= 2;
                case MEJOR_DE_5:
                    // El set termina si algún jugador ha ganado 3 o más rondas.
                    return victoriasJugador1 >= 3 || victoriasJugador2 >= 3;
                default:
                    // En un escenario real, esto no debería ocurrir si TipoSet es un enum bien definido.
                    return false;
            }
        }

        public Jugador getGanadorSet () {
            if (!isSetTerminado()) {
                return null; // El set aún no ha terminado, no hay ganador final.
            }
            if (victoriasJugador1 > victoriasJugador2) {
                return jugador1;
            } else if (victoriasJugador2 > victoriasJugador1) {
                return jugador2;
            } else {
                return null; // Podría indicar un empate o situación no resuelta.
            }
        }


        public Jugador getJugador1 () {
            return jugador1;
        }

        public Jugador getJugador2 () {
            return jugador2;
        }

        public TipoSet getTipoSet () {
            return tipoSet;
        }

        public int getRondasActuales () {
            return rondasActuales;
        }

        public int getVictoriasJugador1 () {
            return victoriasJugador1;
        }

        public int getVictoriasJugador2 () {
            return victoriasJugador2;
        }


    }
}

