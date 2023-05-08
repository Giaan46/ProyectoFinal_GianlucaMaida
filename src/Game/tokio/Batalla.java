package Game.tokio;


import Game.tokio.Personajes.Bestias;
import Game.tokio.Personajes.Heroes;

public class Batalla {

    // metodo por consola
    public static void batallar(Ejercito heroes, Ejercito bestias) {

        int turno = 0;
        do {
                for (int i = 0; i < bestias.personajes.size(); i++) {
                    // generamos un for para que cada vez que la lista fue recorrida incremente el valor asignado para turno asi podemos imprimir por consola que turno es el que se esta jugando
                    for (int j = 0; j == i; j++) {
                        turno++;
                        System.out.println("Turno  " + turno + ':');
                    }

                    Heroes heroe = (Heroes) heroes.getPersonaje(i);
                    Bestias bestia = (Bestias) bestias.getPersonaje(i);
                    // guardamos en variables los resultados de ataques , daño y de vida para que se actualice a medida que pasan los turnos..
                    int atacah = heroe.atacar(bestia);
                    int atacab = bestia.atacar(heroe);
                    int danioH = heroe.recibirAtaque(atacab,bestia);
                    int danioB = bestia.recibirAtaque(atacah,heroe);

                    int vidah = heroe.getVida();
                    int vidab = bestia.getVida();
                    //esquema de lucha consola :
                    System.out.println("Lucha entre " + heroe.getNombre()
                            + " (Vida= " + vidah + " Armadura= " + heroe.getResistenciaArmadura() + ") y "
                            + bestia.getNombre() + " (Vida= " + vidab + " Armadura= " + bestia.getResistenciaArmadura() + ")");
                    System.out.println(heroe.getNombre() + " saca " + atacah + " y le quita " + danioB +
                            " de vida a " + bestia.getNombre());
                    System.out.println(bestia.getNombre() + " saca " + atacab + " y le quita " + danioH +
                            " de vida a " + heroe.getNombre());
                    // actualizamos los valores del daño causado en esta ronda
                    bestia.setVida(bestia.getVida() - danioB);
                    heroe.setVida(heroe.getVida() - danioH);
                    // hacemos un if con la consicion de que personaje tenga vida y sino se elimina de la lista
                    if (heroes.getPersonaje(i).getVida() <= 0) {
                        System.out.println("¡Muere " + heroe.mensaje() + heroes.personajes.get(i).getNombre() + '!');
                        heroes.personajes.remove(heroes.getPersonaje(i));
                    } else if (bestias.getPersonaje(i).getVida() <= 0) {
                        System.out.println("¡Muere " + bestia.mensaje() + bestias.personajes.get(i).getNombre() + '!');
                        bestias.personajes.remove(bestias.getPersonaje(i));

                    }
                }

            }
            while (!bestias.personajes.isEmpty() && !heroes.personajes.isEmpty()) ;
            // luego hacemos otro if para mostrar por pantalla el ganador del combate
            if (bestias.personajes.isEmpty()) {
                System.out.println("¡¡VICTORIA DE LOS HÉROES!!");
            } else if (heroes.personajes.isEmpty()) {
                System.out.println("¡¡VICTORIA DE LAS BESTIAS!!");
            }

        }
    }



