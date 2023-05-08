package Game.tokio.Graficos;

import Game.tokio.Ejercito;
import Game.tokio.Personajes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelCrearPersonaje extends JPanel {

    private JTextField jtNombre;
    private JComboBox<String> jcTipo;

    private JTextField jtVida;
    private JTextField jtArmadura;
    private JButton btaniadir;

    //Atributo para referenciar alguno de los ejercitos de la clase main
    private Ejercito ejercito;

    //Panel con la lista de personajes
    private PanelLista lista;
    CampoDeBatalla campoDeBatalla;


    public PanelCrearPersonaje(String titulo, String[] tipos, Ejercito ejercito) {
        // inicializamos componentes
        jtNombre = new JTextField();
        jcTipo = new JComboBox<String>(tipos);
        jtVida = new JTextField();
        jtArmadura = new JTextField();
        btaniadir = new JButton("añadir");
        btaniadir.addActionListener(new AccionCrearPersonaje());

        this.ejercito = ejercito; // Ejercito referenciado
        lista = new PanelLista(titulo, ejercito);//pasamos titulo de borde y referencia a ejercito
       campoDeBatalla = new CampoDeBatalla(ejercito,ejercito);

        // layout de "cajas" verticales
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

//       cada "caja" apilada verticalmente sera un panel de la clase panleConLabel
        add(new PanelConLabel("Nombre: ", jtNombre));
        add(new PanelConLabel("Tipo: ", jcTipo));
        add(new PanelConLabel("Vida: ", jtVida));
        add(new PanelConLabel("Armadura: ", jtArmadura));

        // Boton añadir
        JPanel pnAniadir = new JPanel();
        pnAniadir.add(btaniadir);
        add(pnAniadir);

        //colocamos el panel lista debajo de todo
        add(lista);

        // combinamos dos bordes, uno titulador y otro vacio para crear algo de relleno
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15),
                BorderFactory.createTitledBorder(titulo)));
    }
    private class PanelConLabel extends JPanel {

        public PanelConLabel(String texto, JComponent componente) {
            //Layout tipo grilla, sera una fila con dos columnas
            setLayout(new GridLayout(1, 2));
            // En la primera columna, la etiqueta
            add(new JLabel(texto));
            // En la segunda columna, el componente que acompaña la etiqueta
            add(componente);
            // inflamos el panel con aldo de borde vacio
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        }
    }
    public class AccionCrearPersonaje implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // hacemos una condicional por si al crear un personaje nos queda algun casillero vacio que de un mensaje
            if (jtVida.getText().isEmpty() || jtArmadura.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacío");
            else { //Ningún campo está vacío

            // ahora metemos en un try catch para que los datos ingresados sean los correctos y de no ser asi de un mensaje por pantalla
                try {
                    Integer valor = Integer.parseInt(jtVida.getText());
                    Integer valor2 = Integer.parseInt(jtArmadura.getText());
                    // Recogemos datos
                    String nombre = jtNombre.getText();
                    String tipo = (String) jcTipo.getSelectedItem();
                    int vida = Integer.parseInt(jtVida.getText());
                    int armadura = Integer.parseInt(jtArmadura.getText());

                    // Creamos nuevo personaje segun tipo
                    switch (tipo) {
                        case "Elfo":
                            ejercito.addPersonaje(new Elfos(nombre, vida, armadura));
                            campoDeBatalla.repaint();
                            break;
                        case "Humano":
                            ejercito.addPersonaje(new Humanos(nombre, vida, armadura));
                            campoDeBatalla.repaint();
                            break;
                        case "Hobbit":
                            ejercito.addPersonaje(new Hobbits(nombre, vida, armadura));
                            campoDeBatalla.repaint();
                            break;
                        case "Trasgo":
                            ejercito.addPersonaje(new Trasgos(nombre, vida, armadura));
                            campoDeBatalla.repaint();
                            break;
                        case "Orco":
                            ejercito.addPersonaje(new Orcos(nombre, vida, armadura));
                            campoDeBatalla.repaint();
                            break;
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El valor tiene que ser numérico");
                }
            }

            // Limpiamos campos
            jtNombre.setText(null);
            jcTipo.setSelectedIndex(0);
            jtVida.setText(null);
            jtArmadura.setText(null);


            //Actualiza lista
            lista.actualizarLista();
            campoDeBatalla.repaint();
            campoDeBatalla.revalidate();



            }
        }

    }




