package Controlador;
 import Modelo.Dado;
 import Modelo.Suma; //usamos suma

//no interactua con el usuario
// calcula la suma
//determina si el resultado es 7

public class JuegodeDados {
    private Dado1 dado1;
    private Dado2 dado2;
    private Suma sumador;

    public JuegoDeDadosControlador() {
        this.dado1 = new Dado();   //crea el dado 1 al instanciar el controlador
        this.dado2 = new Dado();   //crea el dado 2
        this.sumador = new Suma(); //crea el uso para sumar
    }

    public JuegoDeDadosControlador(Suma sumador) {
        this.dado1 = new Dado();   // dados son creados internamente por el controlador.
        this.dado2 = new Dado();
        this.sumador = sumador;    // instancia de.
    }

    public int lanzarDadosYObtenerSuma() {
        dado1.lanzar(); //obj accion
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


//JuegoDeDados 'crea' y 'posee' a sus `Dado`s
//JuegoDeDados 'usa' una instancia de Suma



