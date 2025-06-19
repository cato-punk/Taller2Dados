package Controlador;

import Modelo.Dado;
import Modelo.Suma;

public class JuegodeDados {
    private Dado dado1;
    private Dado dado2;
    private Suma sumador;

    public JuegodeDados() {
        this.dado1 = new Dado();
        this.dado2 = new Dado();
        this.sumador = new Suma();
    }

    public JuegodeDados(Suma sumador) {
        this.dado1 = new Dado();
        this.dado2 = new Dado();
        this.sumador = sumador;
    }

    public int lanzarDadosYObtenerSuma() {
        dado1.lanzar();
        dado2.lanzar();
        return sumador.sumar(dado1.getCaraSuperior(), dado2.getCaraSuperior());
    }

    public boolean esVictoria(int suma) {
        return suma == 7;
    }

    public int getCaraDado1() {
        return dado1.getCaraSuperior();
    }

    public int getCaraDado2() {
        return dado2.getCaraSuperior();
    }
}
