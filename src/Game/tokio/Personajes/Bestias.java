package Game.tokio.Personajes;

import java.util.Random;

public class Bestias extends Personaje {


    public Bestias(String nombre, int vida, int resistencia) {
        super(nombre, vida, resistencia);
    }

    @Override
    public int atacar(Personaje enemigo) {
        // se lanza un dado de 0 a 90 al azar
        Random dado = new Random();
        int dado1 = dado.nextInt(91);
        return dado1;
    }



    @Override
    public String mensaje() {
        return mensaje();
    }

}



