package Game.tokio.Graficos;

import Game.tokio.Ejercito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BatallaGr extends JFrame{

    //Modelo
    private Ejercito bestias;
    private Ejercito heroes;

    // Vistas
    private PanelCrearPersonaje crearHeroes;
    private PanelCrearPersonaje crearBestias;

    private PanelTexto textArea;

    private CampoDeBatalla campoDeBatalla;

    public BatallaGr() {
        bestias = new Ejercito();
        heroes = new Ejercito();
        crearHeroes = new PanelCrearPersonaje("Heroes", new String[]{"Elfo", "Humano", "Hobbit"}, heroes);
        crearBestias = new PanelCrearPersonaje("Bestias", new String[]{"Orco", "Trasgo"}, bestias);
        textArea = new PanelTexto();
        textArea.setAccionBotonLuchar(new AccionBotonLuchar());
        campoDeBatalla = new CampoDeBatalla(heroes,bestias);

        // hacemos un jpanel con los paneles para crear los personaje
        JPanel pnSuperior = new JPanel();
        pnSuperior.setBackground(Color.BLACK);
        pnSuperior.add(crearHeroes);
        pnSuperior.add(crearBestias);
        // introducimos un borde a la imagen
        campoDeBatalla.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createTitledBorder("CampoDeBatalla")));
        campoDeBatalla.setBackground(Color.white);

        add(campoDeBatalla,BorderLayout.CENTER);
        add(pnSuperior,BorderLayout.EAST);
        add(textArea,BorderLayout.SOUTH);

        setTitle("Batalla señor de los anillos ");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    private class AccionBotonLuchar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            textArea.BorrarText();
        BatallaHilo batallaHilo = new BatallaHilo(heroes,bestias,textArea);
        campoDeBatalla.repaint();
        batallaHilo.start();


        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BatallaGr();

            }
        });
    }
}
