package Game.tokio.Personajes;

import java.util.Random;

public class Trasgos extends Bestias {


    @Override
    public int atacar(Personaje enemigo) {
        super.atacar(enemigo);
        Random dado = new Random();
        int dado1 = dado.nextInt(90+1);
        return dado1 ;
    }
    public Trasgos(String nombre, int vida, int resistencia  ) {
        super(nombre, vida, resistencia);

    }

    public String mensaje(){
        return "Trasgo ";
    }

    }


