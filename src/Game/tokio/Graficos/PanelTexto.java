package Game.tokio.Graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelTexto extends JPanel {

    private JTextArea textArea;
    private JButton btiniciar;
    private JScrollPane scrollPane;

    public PanelTexto(){
        textArea = new JTextArea();
        textArea.setEditable(false);
        btiniciar = new JButton(" BATALLAR! ");

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(textArea);
        scrollPane.setPreferredSize(new Dimension(50,150));
        scrollPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,10,10,10),
                BorderFactory.createLoweredSoftBevelBorder()));

        JPanel pnBoton = new JPanel();
        pnBoton.add(btiniciar);

        setLayout(new BorderLayout());
        add(pnBoton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0,5,5,5),
                BorderFactory.createRaisedSoftBevelBorder()));
        setBackground(Color.BLACK);

    }
    // la accion de este boton se escribira en otra clase
    public void setAccionBotonLuchar(ActionListener accion){
        textArea.setText(" ");
        btiniciar.addActionListener(accion);
    }
    public void nuevaLinea(String linea){
        textArea.append(linea + " \n ");


    }
    public void BorrarText(){
        textArea.setText(" ");   //hacemos un setText con un espacio vacio para borrar la batalla anterior en caso de jugar otra partida
    }
}
