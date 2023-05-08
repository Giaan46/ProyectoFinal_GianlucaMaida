package Game.tokio.Personajes;

import javax.swing.*;
import java.awt.*;

public class Humanos extends Heroes {
private ImageIcon imagen;
    public Humanos(String nombre, int vida, int resistencia) {

        super(nombre, vida, resistencia);
        this.imagen = imagen;
    }

public String mensaje(){
        return "Humano ";
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