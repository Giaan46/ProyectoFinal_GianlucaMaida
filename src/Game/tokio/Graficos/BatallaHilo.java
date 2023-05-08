package Game.tokio.Graficos;

import Game.tokio.Ejercito;
import Game.tokio.Personajes.Bestias;
import Game.tokio.Personajes.Heroes;

public class BatallaHilo extends Thread{

    private Ejercito heroes;
    private Ejercito bestias;
    private PanelTexto textArea;
    public BatallaHilo(Ejercito heroes,Ejercito bestias, PanelTexto textArea){
        this.heroes = heroes;
        this.bestias = bestias;
        this.textArea = textArea;
    }
@Override
   public void run() {
        int turno = 0;
        do {
            for (int i = 0; i < bestias.personajes.size(); i++) {
                for (int j = 0; j == i; j++) {
                    turno++;
                    String mensajeTurno = "Turno " + turno + ": \n";
                    textArea.nuevaLinea(mensajeTurno);

                }
                // obtenemos los personajes que van a luchar
                Heroes heroe = (Heroes) heroes.getPersonaje(i);
                Bestias bestia = (Bestias) bestias.getPersonaje(i);

                // guardamos los resultados de los ataques y el daño recibido para cada personaje
                int atacah = heroe.atacar(bestia);
                int atacab = bestia.atacar(heroe);
                int danioH = heroe.recibirAtaque(atacab,bestia);
                int danioB = bestia.recibirAtaque(atacah,heroe);
                int vidah = heroe.getVida();
                int vidab = bestia.getVida();

                // Esquema de la lucha
                String mensajeLucha = "Lucha entre " + heroe.getNombre()
                        + " (Vida= " + vidah + " Armadura= " + heroe.getResistenciaArmadura() + ") y "
                        + bestia.getNombre() + " (Vida= " + vidab + " Armadura= " + bestia.getResistenciaArmadura() + ")\n";
                String mensajeAtaqueHeroe = heroe.getNombre() + " saca " + atacah + " y le quita " + danioB +
                        " de vida a " + bestia.getNombre() + "\n";
                String mensajeAtaqueBestia = bestia.getNombre() + " saca " + atacab + " y le quita " + danioH +
                        " de vida a " + heroe.getNombre() + "\n";
                Pausa(200);


                // Agregamos los mensajes al JTextArea
                textArea.nuevaLinea(mensajeLucha);
                Pausa(200);
                textArea.nuevaLinea(mensajeAtaqueHeroe);
               Pausa(200);
                textArea.nuevaLinea(mensajeAtaqueBestia);
                Pausa(200);

                // Actualizamos los valores del daño causado en esta ronda
                bestia.setVida(bestia.getVida() - danioB);
                heroe.setVida(heroe.getVida() - danioH);

                // Si alguno de los personajes tiene vida menor o igual a 0, lo eliminamos de la lista de personajes
                if (heroes.getPersonaje(i).getVida() <= 0) {
                    String mensajeMuerte = "¡Muere " + heroe.mensaje() + heroes.personajes.get(i).getNombre() + "!\n";
                    textArea.nuevaLinea(mensajeMuerte);
                    heroes.personajes.remove(heroes.getPersonaje(i));
                   Pausa(100);
                } else if (bestias.getPersonaje(i).getVida() <= 0) {
                    String mensajeMuerte = "¡Muere " + bestia.mensaje() + bestias.personajes.get(i).getNombre() + "!\n";
                    textArea.nuevaLinea(mensajeMuerte);
                    bestias.personajes.remove(bestias.getPersonaje(i));
                   Pausa(100);
                }
            }
            // luego hacemos otro if para mostrar por pantalla el ganador del combate
                if (bestias.personajes.isEmpty()) {
                    String mensajeGanaH = "¡¡VICTORIA DE LOS HÉROES!!";
                    textArea.nuevaLinea(mensajeGanaH);
                    break;
                } else if (heroes.personajes.isEmpty()) {
                    String mensajeGanaB = "¡¡VICTORIA DE LAS BESTIAS!!";
                    textArea.nuevaLinea(mensajeGanaB);
                    break;
                }

        } while (!bestias.personajes.isEmpty() || !heroes.personajes.isEmpty());

    }
    public void Pausa(long milis){
        try{
            sleep(milis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
