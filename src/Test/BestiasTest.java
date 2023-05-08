package Test;

import Game.tokio.Personajes.Bestias;
import Game.tokio.Personajes.Heroes;
import Game.tokio.Personajes.Personaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BestiasTest {

    @Test
    public void ataque() {
        Bestias bestia = new Bestias("Gorgonita", 100, 20);
        Personaje enemigo = new Heroes("Legolas", 100, 15);

        int ataque = bestia.atacar(enemigo);
        Assertions.assertTrue(ataque >= 0 && ataque <= 90);
        // Este test verifica que el método atacar de la clase Bestias retorne un número entre 0 y 90 al azar, como se define en el método. Si el valor retornado está dentro de ese rango, el test pasa exitosamente.

    }
    @Test
    public void RecibirAtaque() {
        Bestias bestias = new Bestias("ugluk", 100, 50);
        Heroes heroes = new Heroes("Legolas", 100, 50);

        int ataque = heroes.atacar(bestias);
        bestias.recibirAtaque(ataque,heroes);
        Assertions.assertTrue(bestias.recibirAtaque(ataque,heroes) == ataque - bestias.getResistenciaArmadura());
        // Este test verifica que el daño probocado sea el mismo que el ataque del enemigo

    }
}







