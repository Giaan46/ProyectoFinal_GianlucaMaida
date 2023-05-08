package Game.tokio;

import Game.tokio.Personajes.*;

import java.util.ArrayList;

public class Ejercito {

    public ArrayList<Personaje> personajes;

    public Ejercito() {
        personajes = new ArrayList<Personaje>();

    }

    public void addPersonaje(Personaje personaje) {
        // añadimos un personaje
        personajes.add(personaje);
    }

    public Personaje getPersonaje(int posicion) {
        try {
            // retornamos un personaje en la posicion
            return personajes.get(posicion);
        } catch (Exception e) {
            // si no hay personajes en esa posicion
            return null;
        }

    }

}


