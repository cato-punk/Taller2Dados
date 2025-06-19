package Modelo;
import java.util.Random;
//simular el lanzamiento de un dado de seis caras
//el valor de la cara superior
public class Dado {
    private int caraSuperior; //nato esto lo hice prvado porque quero encapsular el dado osea su estado
    private static final Random random = new Random(); //lo deje final para que random no cambie

    public Dado() {
        this.caraSuperior = 1; // inicializamos en 1

    }

    public void lanzar() {
        this.caraSuperior = random.nextInt(6) + 1; //tira numeros de 1 a 6, cuenta el cero 0 a 5 +1
    }
//que tenemos que obtener la cara

    public int getCaraSuperior() {
        return caraSuperior;
    }

}

//otras clases la usan o la contienen, no tiende otras relaciones

