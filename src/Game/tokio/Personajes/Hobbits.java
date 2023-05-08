package Game.tokio.Personajes;

import java.util.Random;

public  class Hobbits extends Heroes {


    public Hobbits(String nombre, int vida, int resistencia) {
        super(nombre, vida, resistencia);

    }

    @Override
    public int atacar(Personaje enemigo) {
        // -5 ataque trasgos
        if (enemigo instanceof Trasgos) {
            Random dado = new Random();
            int tirada1 = dado.nextInt(101);
            int tirada2 = dado.nextInt(101);
            return Math.max(tirada1, tirada2) - 5;

        } else {
            return super.atacar(enemigo);
        }
    }

    public String mensaje() {
        return "Hobbit ";
    }


    public int recibirAtaque(int ataque, Personaje enemigo) {
        if (enemigo instanceof Orcos && ataque > getResistenciaArmadura()-getResistenciaArmadura()/10){
            return ataque - (getResistenciaArmadura() - getResistenciaArmadura()/10);
        }else if (enemigo instanceof Orcos && ataque < getResistenciaArmadura()-getResistenciaArmadura()/10) {
            return 0;
        }
        return super.recibirAtaque(ataque, enemigo);
    }

}

