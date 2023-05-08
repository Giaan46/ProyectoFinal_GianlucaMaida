package Game.tokio.Graficos;

import Game.tokio.Ejercito;
import Game.tokio.Personajes.*;
import javax.swing.*;
import java.awt.*;


public class CampoDeBatalla extends JPanel {

    private Ejercito heroes;
    private Ejercito bestias;

    public CampoDeBatalla(Ejercito heroes, Ejercito bestias) {
        this.heroes = heroes;
        this.bestias = bestias;

        setBackground(Color.white);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja el fondo
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Game/tokio/Multimedia/FondoJuego.png"));
        g.drawImage(backgroundImage.getImage(), 0, 0, 750, 520, null);

        int posicionH = 350,posicionB = 400; // posición fija en el eje X de heroes y de bestias
        int dy = 50; // distancia entre personajes en el eje Y
        //  Dibuja los personajes
        if (!heroes.personajes.isEmpty())
            for (int i = 0; i < heroes.personajes.size(); i++) {
                int y = 100; // posición inicial en el eje Y
                if (heroes.getPersonaje(i) instanceof Elfos) {
                    ImageIcon elfo = new ImageIcon(getClass().getResource("/Game/tokio/Multimedia/elfo.PNG"));
                    g.drawImage(elfo.getImage(), 350, y + i * dy , null);

                } else if (heroes.getPersonaje(i) instanceof Humanos) {
                    ImageIcon humano = new ImageIcon(getClass().getResource("/Game/tokio/Multimedia/humano1.PNG"));
                    g.drawImage(humano.getImage(), 350, y + i * dy, null);


                } else if (heroes.getPersonaje(i) instanceof Hobbits) {
                    ImageIcon hobbits = new ImageIcon(getClass().getResource("/Game/tokio/Multimedia/hobbit.PNG"));
                    g.drawImage(hobbits.getImage(), 350, y + i * dy, null);

                }
                if (!bestias.personajes.isEmpty())

                    for (int j = 0; j < heroes.personajes.size(); j++) {
                        if (bestias.getPersonaje(j) instanceof Orcos) {
                            ImageIcon orco = new ImageIcon(getClass().getResource("/Game/tokio/Multimedia/orco1.PNG"));
                            g.drawImage(orco.getImage(), 400, y + j * dy, null);


                        } else if (bestias.getPersonaje(j) instanceof Trasgos) {
                            ImageIcon trasgo = new ImageIcon(getClass().getResource("/Game/tokio/Multimedia/trasgo.PNG"));
                            g.drawImage(trasgo.getImage(), 400, y + j * dy, null);


                        }


                    }
                }
                revalidate();
                repaint();
                setOpaque(false);
            }
    }






