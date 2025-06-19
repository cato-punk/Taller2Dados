package Controlador;

import Modelo.Jugador;
import Modelo.ResultadoRonda;
import Modelo.Suma;
import Modelo.TipoSet;
import Modelo.Dado;

public class JuegoVersus {
    private Jugador jugador1;
    private Jugador jugador2;
    private int rondasActuales;
    private int victoriasJugador1;
    private int victoriasJugador2;
    private TipoSet tipoSet;
    private JuegodeDados controladorTurnoJ1;
    private JuegodeDados controladorTurnoJ2;

    public JuegoVersus(Jugador jugador1, Jugador jugador2, TipoSet tipoSet) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tipoSet = tipoSet;
        this.rondasActuales = 0;
        this.victoriasJugador1 = 0;
        this.victoriasJugador2 = 0;
        this.controladorTurnoJ1 = new JuegodeDados();
        this.controladorTurnoJ2 = new JuegodeDados();
    }

    public ResultadoRonda jugarRonda() {
        rondasActuales++;

        int sumaJugador1 = controladorTurnoJ1.lanzarDadosYObtenerSuma();
        boolean ganoJugador1Ronda = controladorTurnoJ1.esVictoria(sumaJugador1);

        int sumaJugador2 = controladorTurnoJ2.lanzarDadosYObtenerSuma();
        boolean ganoJugador2Ronda = controladorTurnoJ2.esVictoria(sumaJugador2);

        if (ganoJugador1Ronda) victoriasJugador1++;
        if (ganoJugador2Ronda) victoriasJugador2++;

        return new ResultadoRonda(
                rondasActuales,
                jugador1.getNombre(), controladorTurnoJ1.getCaraDado1(), controladorTurnoJ1.getCaraDado2(), sumaJugador1, ganoJugador1Ronda,
                jugador2.getNombre(), controladorTurnoJ2.getCaraDado1(), controladorTurnoJ2.getCaraDado2(), sumaJugador2, ganoJugador2Ronda
        );
    }

    public boolean isSetTerminado() {
        return switch (tipoSet) {
            case MEJOR_DE_1 -> victoriasJugador1 > 0 || victoriasJugador2 > 0;
            case MEJOR_DE_3 -> victoriasJugador1 >= 2 || victoriasJugador2 >= 2;
            case MEJOR_DE_5 -> victoriasJugador1 >= 3 || victoriasJugador2 >= 3;
        };
    }

    public Jugador getGanadorSet() {
        if (!isSetTerminado()) return null;

        if (victoriasJugador1 > victoriasJugador2) return jugador1;
        else if (victoriasJugador2 > victoriasJugador1) return jugador2;
        else return null; // empate
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public TipoSet getTipoSet() {
        return tipoSet;
    }

    public int getRondasActuales() {
        return rondasActuales;
    }

    public int getVictoriasJugador1() {
        return victoriasJugador1;
    }

    public int getVictoriasJugador2() {
        return victoriasJugador2;
    }
}
