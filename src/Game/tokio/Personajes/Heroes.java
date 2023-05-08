package Game.tokio.Personajes;

import java.util.Random;

public class Heroes extends Personaje {


    public Heroes(String nombre, int vida, int resistencia) {
        super(nombre, vida, resistencia);
    }

    @Override
    public int atacar(Personaje enemigo) {
        // el ataque será el mejor lanzamiento entre 2 dados de 0 a 100
        Random dado = new Random();
        int dado1 = dado.nextInt(100 + 1);
        int dado2 = dado.nextInt(100 + 1);
        return Math.max(dado1, dado2);
    }

    @Override
    public String mensaje() {
        return mensaje();
    }


}
