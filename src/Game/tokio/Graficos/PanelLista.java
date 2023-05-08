package Game.tokio.Graficos;

import Game.tokio.Ejercito;
import Game.tokio.Personajes.Personaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelLista extends JPanel {

    private JList<Personaje> lista;
    private DefaultListModel<Personaje> modeloLista;

    private JButton btSubir;
    private JButton btBajar;
    private JButton btEliminar;


    private Ejercito ejercito;

    public PanelLista(String titulo, Ejercito ejercito) {
        this.ejercito = ejercito;

        lista = new JList<Personaje>();
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modeloLista = new DefaultListModel<Personaje>();
        lista.setModel(modeloLista);

        btSubir = new JButton("Subir");
        btSubir.addActionListener(new AccionSubirBajar(-1));
        btBajar = new JButton("Bajar");
        btBajar.addActionListener(new AccionSubirBajar(1));
        btEliminar = new JButton("Eliminar");
        btEliminar.addActionListener(new AccionEliminar());


        setLayout(new BorderLayout());

        JScrollPane scrollLista = new JScrollPane();

        scrollLista.setViewportView(lista);
        scrollLista.setBorder(BorderFactory.createTitledBorder(null, titulo));
        add(scrollLista, BorderLayout.SOUTH);

        JPanel pnBotones = new JPanel();
        pnBotones.add(btBajar);
        pnBotones.add(btSubir);
        pnBotones.add(btEliminar);

        add(pnBotones, BorderLayout.CENTER);



    }
        public void actualizarLista() {
            modeloLista.clear();
            for (Personaje pers : ejercito.personajes)//Ejercito no proporciona el arrayList
                modeloLista.addElement(pers);
            lista.setModel(modeloLista);
        }
        private class AccionEliminar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Personaje seleccionado = lista.getSelectedValue();
            if (seleccionado == null)
                JOptionPane.showMessageDialog(null, "selecciona un personaje ");
            else {
                ejercito.personajes.remove(seleccionado);// Eliminamos del arraylist
                actualizarLista();
            }
        }
    }
    private class AccionSubirBajar implements ActionListener{

        private int desplazamiento; // -1 para subir y +1 para bajar
        public AccionSubirBajar(int desplazamiento){
            this.desplazamiento = desplazamiento;

        }


        @Override
        public void actionPerformed(ActionEvent e) {
        // personaje seleccionado en jlist
        Personaje seleccionado = lista.getSelectedValue();
        if(seleccionado == null)
            JOptionPane.showMessageDialog(null,"selecciona un personaje");
        else{
            // indice de soldado seleccionado, es igual a ambas listas
            int indiceSelleccionado = lista.getSelectedIndex();
            // indice del personaje para intercambiar , puede que sea uno anterio o uno posterior
            int indiceIntercambiar = indiceSelleccionado + desplazamiento;
            // buscamos en el arraylist, el personaje para intercambiar
            Personaje intercambiar = ejercito.getPersonaje(indiceIntercambiar);

            // si intercambiar fuera null, es que el soldado seleccionado no se puede intercambiar
            if(intercambiar != null){
                // seteamos los soldados e intercambiamos los indices
                ejercito.personajes.set(indiceSelleccionado,intercambiar);
                ejercito.personajes.set(indiceIntercambiar, seleccionado);
                actualizarLista();

            }
        }
        }
    }


    }

