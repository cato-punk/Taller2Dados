package Modelo;
public class ResultadoRonda {


    private int numeroRonda;

    private String nombreJugador1;
    private int caraDado1J1;
    private int caraDado2J1;
    private int sumaJ1;
    private boolean ganoJ1Ronda; // (suma 7)

    // del Jugador 2 para esta ronda
    private String nombreJugador2;
    private int caraDado1J2;
    private int caraDado2J2;
    private int sumaJ2;
    private boolean ganoJ2Ronda; // si el Jugador 2 ganó su tirada individual (suma 7)


    public ResultadoRonda(int numeroRonda,
                          String nombreJugador1, int caraDado1J1, int caraDado2J1, int sumaJ1, boolean ganoJ1Ronda,
                          String nombreJugador2, int caraDado1J2, int caraDado2J2, int sumaJ2, boolean ganoJ2Ronda) {
        this.numeroRonda = numeroRonda;
        this.nombreJugador1 = nombreJugador1;
        this.caraDado1J1 = caraDado1J1;
        this.caraDado2J1 = caraDado2J1;
        this.sumaJ1 = sumaJ1;
        this.ganoJ1Ronda = ganoJ1Ronda;
        this.nombreJugador2 = nombreJugador2;
        this.caraDado1J2 = caraDado1J2;
        this.caraDado2J2 = caraDado2J2;
        this.sumaJ2 = sumaJ2;
        this.ganoJ2Ronda = ganoJ2Ronda;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public String getNombreJugador1() {
        return nombreJugador1;
    }

    public int getCaraDado1J1() {
        return caraDado1J1;
    }

    public int getCaraDado2J1() {
        return caraDado2J1;
    }

    public int getSumaJ1() {
        return sumaJ1;
    }

    public boolean isGanoJ1Ronda() {
        return ganoJ1Ronda;
    }

    public String getNombreJugador2() {
        return nombreJugador2;
    }

    public int getCaraDado1J2() {
        return caraDado1J2;
    }

    public int getCaraDado2J2() {
        return caraDado2J2;
    }

    public int getSumaJ2() {
        return sumaJ2;
    }

    public boolean isGanoJ2Ronda() {
        return ganoJ2Ronda;
    }
}
