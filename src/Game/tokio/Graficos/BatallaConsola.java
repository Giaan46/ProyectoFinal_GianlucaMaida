package Game.tokio.Graficos;

import Game.tokio.Batalla;
import Game.tokio.Ejercito;
import Game.tokio.Personajes.*;



public class BatallaConsola {
    public static void main(String[] args) {
      Ejercito heroes1 = new Ejercito();
      Ejercito bestias1 = new Ejercito();


        heroes1.addPersonaje(new Elfos("Legolas", 150, 30));
        heroes1.addPersonaje(new Humanos("Aragorn", 150, 50));
        heroes1.addPersonaje(new Humanos("Boromir",100, 60));
        heroes1.addPersonaje(new Humanos("Gandalf",300, 10));
        heroes1.addPersonaje(new Hobbits("Frodo", 20, 10));

        bestias1.addPersonaje(new Orcos("Lurtz", 200, 60));
        bestias1.addPersonaje(new Orcos("Shagrat", 220, 50));
        bestias1.addPersonaje(new Trasgos("Uglúk", 120, 30));
        bestias1.addPersonaje(new Trasgos("Mauhúr", 100, 30));


      Batalla.batallar(heroes1,bestias1);
    }
}
