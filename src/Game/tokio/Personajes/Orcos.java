package Game.tokio.Personajes;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Random;

public class Orcos extends Bestias {


    public Orcos(String nombre, int vida, int resistencia) {
        super(nombre, vida, resistencia);
    }
    @Override
    public int atacar(Personaje enemigo){
        // baja 10% de armadura del oponente
        Random dado = new Random();
        int dado1 = dado.nextInt(90+1);
        int resistenciaEnemigo = enemigo.getResistenciaArmadura() / 10;
        return dado1 + resistenciaEnemigo;
    }
    public String mensaje(){
        return "Orco ";
    }

}
