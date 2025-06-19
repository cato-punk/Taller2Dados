package Modelo;
//solo representa al juagdor
//almacena y gestiona info del jugador
public class Jugador {
    private String nombre;
    private int puntaje; //lo inicia en cero para luego representar la suma pero sgue para el jugador ojo

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public String getNombre() {
        return nombre;
    } //obtener el nombre del jugador para la consola

    public int getPuntaje() {
        return puntaje;
    } //lo mismo que el nombre

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    } //para ir modificando el puntaje

    public void agregarPuntos(int puntos) {
        this.puntaje += puntos;
    }

}
//JuegoVersusControlador tiene instancias de Jugador (jugador1, jugador2) o usa?
//con el test del jugador es dependencia