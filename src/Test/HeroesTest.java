package Test;

import Game.tokio.Personajes.Bestias;
import Game.tokio.Personajes.Heroes;
import Game.tokio.Personajes.Personaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeroesTest {

    @Test
    public void ataque() {
        Heroes heroes = new Heroes("Gorgonita", 100, 20);
        Personaje enemigo = new Heroes("Legolas", 100, 15);

        int ataque = heroes.atacar(enemigo);
// Este test verifica que el método atacar de la clase Bestias retorne un número entre 0 y 90 al azar, como se define en el método. Si el valor retornado está dentro de ese rango, el test pasa exitosamente.
        Assertions.assertTrue(ataque >= 0 && ataque <= 90);
    }
    @Test
    public void RecibirAtaque(){
        Heroes heroes = new Heroes("Legolas",100,20);
        Bestias bestias = new Bestias("ugluk",100,20);
        int ataque = bestias.atacar(heroes);
        heroes.recibirAtaque(ataque,bestias);
        Assertions.assertTrue(heroes.recibirAtaque(ataque,bestias) == ataque - heroes.getResistenciaArmadura());
        // Este test verifica que el daño probocado sea el mismo que el ataque del enemigo
    }
}
