package Game.tokio.Personajes;

import java.util.Random;

public class Elfos extends Heroes {
 Bestias bestias;
    // +10 de ataque contra los orcos
    public Elfos(String nombre, int vida, int resistencia) {
        super(nombre, vida, resistencia);

    }

    public int atacar(Personaje enemigo) {
        if (enemigo instanceof Orcos) {
            Random dado = new Random();
            int tirada1 = dado.nextInt(100 + 1);
            int tirada2 = dado.nextInt(100 + 1);
            return Math.max(tirada1, tirada2 + 10);
        }
        return super.atacar(enemigo);
    }
    public String mensaje() {
        return "Elfo ";
    }

    @Override
    public int recibirAtaque(int ataque, Personaje enemigo) {
        if (enemigo instanceof Orcos && ataque > getResistenciaArmadura()-getResistenciaArmadura()/10){
            return ataque - (getResistenciaArmadura() - getResistenciaArmadura()/10);
        }else if (enemigo instanceof Orcos && ataque < getResistenciaArmadura()-getResistenciaArmadura()/10) {
            return 0;
        }
        return super.recibirAtaque(ataque, enemigo);
    }

    }
