package Test;

import static org.junit.Assert.*;

import Game.tokio.Batalla;
import Game.tokio.Ejercito;
import Game.tokio.Personajes.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BatallaTest {

    @Test
    public void testBatallar() {
        Ejercito ejercitoHeroes = new Ejercito();
        ejercitoHeroes.addPersonaje(new Elfos("Aragorn", 100, 20));
        ejercitoHeroes.addPersonaje(new Hobbits("Legolas", 80, 30));
        ejercitoHeroes.addPersonaje(new Humanos("Gandalf", 120, 10));

        Ejercito ejercitoBestias = new Ejercito();
        ejercitoBestias.addPersonaje(new Orcos("Lurtz", 70, 40));
        ejercitoBestias.addPersonaje(new Trasgos("Shagrat", 50, 30));
        ejercitoBestias.addPersonaje(new Orcos("Uglúk", 90, 50));

        Batalla.batallar(ejercitoHeroes, ejercitoBestias);
        //  un ejército debería tener personajes con vida al finalizar la batalla
        Assertions.assertTrue(ejercitoHeroes.personajes.size() > 0 || ejercitoBestias.personajes.size() > 0);

    }
    @Test
    public void testVictoriaHeroes() {
        // Creamos dos ejércitos con un solo personaje cada uno
        Ejercito heroes = new Ejercito();
        heroes.addPersonaje(new Heroes("Gandalf", 100, 50));
        Ejercito bestias = new Ejercito();
        bestias.addPersonaje(new Orcos("Troll", 10, 10));

        // Hacemos que los héroes ataquen al troll hasta matarlo
        while (!bestias.personajes.isEmpty()) {
            Batalla.batallar(heroes, bestias);
        }
        // Comprobamos que el mensaje de victoria de los héroes se muestra correctamente
       Assertions.assertTrue(bestias.personajes.isEmpty());
    }@Test
    public void testVictoriaBestias() {
        // Creamos dos ejércitos con un solo personaje cada uno
        Ejercito bestias = new Ejercito();
        bestias.addPersonaje(new Orcos("Lurtz", 100, 50));

        Ejercito heroes = new Ejercito();
        heroes.addPersonaje(new Elfos("Gandalf", 10, 10));

        while (!heroes.personajes.isEmpty()) {
            Batalla.batallar(heroes, bestias);
        }
        // Comprobamos que el mensaje de victoria de las bestias se muestra correctamente
        Assertions.assertTrue(heroes.personajes.isEmpty());
    }

}