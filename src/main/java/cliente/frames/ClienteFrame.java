package cliente.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;

public class ClienteFrame extends JFrame {
    public static final long serialVersionUID = 42L;
    private int ancho = 800;
    private int alto = 500;

    // AWT members
    protected JMenuBar menuBar;
    protected JMenu menuArchivo;
    protected JMenu menuProvincias;
    protected JMenu menuPoblaciones;
    protected JMenu menuAyuda;

    protected JMenuItem menuItemRecuperarAlmacen;
    protected JMenuItem menuItemGuardarAlmacen;
    protected JMenuItem menuItemSalir;
    protected JMenuItem menuItemNuevaProvincia;
    protected JMenuItem menuItemBorrarProvincia;
    protected JMenuItem menuItemNuevaPoblacion;
    protected JMenuItem menuItemBorrarPoblacion;
    protected JMenuItem menuItemOrdenarPorNombre;
    protected JMenuItem menuItemOrdenarPorHabitantes;
    protected JMenuItem menuItemModificarPoblacion;
    protected JMenuItem menuItemMoverPoblacion;
    protected JMenuItem menuItemAcercaDe;

    protected JPanel panelBotones;
    protected JPanel panelEstado;
    protected JPanel panelProvinciasPoblaciones;
    protected JPanel panelPredicciones;
    protected JPanel panelProvincias;
    protected JPanel panelPoblaciones;

    protected JButton buttonNuevaProvincia;
    protected JButton buttonNuevaPoblacion;
    protected JButton buttonActualizarPrediccion;

    protected JLabel labelProvincias;
    protected JLabel labelPoblaciones;
    protected JLabel labelPredicciones;
    protected JLabel labelEventos;

    protected DefaultListModel<String> listModelProvincias;
    protected DefaultListModel<String> listModelPoblaciones;
    protected DefaultListModel<String> listModelPredicciones;

    protected JList<String> listProvincias;
    protected JList<String> listPoblaciones;
    protected JList<String> listPredicciones;


    /**
     * Constructor para la ventana del cliente
     *
     * @param titulo String del título
     * @return void
     */
    public ClienteFrame(String titulo) {
        super(titulo);
        initialize();
        setupLayout();
    }

    /**
     * Inicializa los componentes de esta venatana
     *
     * @return void
     */
    private void initialize() {
        menuBar = new JMenuBar();
        menuArchivo = new JMenu("Archivo");
        menuProvincias = new JMenu("Provincias");
        menuPoblaciones = new JMenu("Poblaciones");
        menuAyuda = new JMenu("Ayuda");

        menuItemRecuperarAlmacen = new JMenuItem(
                "Recuperar almacén");
        menuItemGuardarAlmacen = new JMenuItem("Guardar almacén");
        menuItemSalir = new JMenuItem("Salir");
        menuItemNuevaProvincia = new JMenuItem("Nueva provincia");
        menuItemBorrarProvincia = new JMenuItem("Borrar provincia");
        menuItemNuevaPoblacion = new JMenuItem("Nueva población");
        menuItemBorrarPoblacion = new JMenuItem("Borrar población");
        menuItemOrdenarPorNombre = new JMenuItem(
                "Ordenar por nombre");
        menuItemOrdenarPorHabitantes = new JMenuItem(
                "Ordenar por habitantes");
        menuItemModificarPoblacion = new JMenuItem(
                "Modificar población");
        menuItemMoverPoblacion = new JMenuItem("Mover población");
        menuItemAcercaDe = new JMenuItem("Acerca de");

        panelBotones = new JPanel();
        panelEstado = new JPanel();
        panelProvinciasPoblaciones = new JPanel();
        panelProvincias = new JPanel();
        panelPoblaciones = new JPanel();
        panelPredicciones = new JPanel();

        buttonActualizarPrediccion = new JButton(
                "Actualizar predicción");
        buttonNuevaProvincia = new JButton("Nueva provincia");
        buttonNuevaPoblacion = new JButton("Nueva población");

        labelProvincias = new JLabel("Provincias:");
        labelPoblaciones = new JLabel("Poblaciones:");
        labelPredicciones = new JLabel("Predicciones de ");
        labelEventos = new JLabel("Gestor AEMET v1.0 (PAA)");

        listModelProvincias = new DefaultListModel<String>();
        listModelPoblaciones = new DefaultListModel<String>();
        listModelPredicciones = new DefaultListModel<String>();

        listProvincias = new JList<String>(listModelProvincias);
        listPoblaciones = new JList<String>(listModelPoblaciones);
        listPredicciones = new JList<String>(listModelPredicciones);
    }

    /**
     * Coloca los componentes de esta venatana
     * en las posiciones correspondientes
     *
     * @return void
     */
    private void setupLayout() {
        setSize(ancho, alto);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        menuArchivo.add(menuItemRecuperarAlmacen);
        menuArchivo.add(menuItemGuardarAlmacen);
        menuArchivo.addSeparator();
        menuArchivo.add(menuItemSalir);
        menuProvincias.add(menuItemNuevaProvincia);
        menuProvincias.add(menuItemBorrarProvincia);
        menuPoblaciones.add(menuItemNuevaPoblacion);
        menuPoblaciones.add(menuItemBorrarPoblacion);
        menuPoblaciones.add(menuItemOrdenarPorNombre);
        menuPoblaciones.add(menuItemOrdenarPorHabitantes);
        menuPoblaciones.addSeparator();
        menuPoblaciones.add(menuItemModificarPoblacion);
        menuPoblaciones.add(menuItemMoverPoblacion);
        menuAyuda.add(menuItemAcercaDe);

        menuBar.add(menuArchivo);
        menuBar.add(menuProvincias);
        menuBar.add(menuPoblaciones);
        menuBar.add(menuAyuda);
        setJMenuBar(menuBar);

        panelBotones.setLayout (new FlowLayout(FlowLayout.LEFT));
        panelBotones.setBackground(Color.lightGray);
        panelBotones.add(buttonActualizarPrediccion);
        panelBotones.add(buttonNuevaProvincia);
        panelBotones.add(buttonNuevaPoblacion);
        add(panelBotones, BorderLayout.NORTH);

        panelEstado.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelEstado.setBackground(Color.lightGray);
        panelEstado.add(labelEventos);
        add(panelEstado, BorderLayout.SOUTH);

        panelProvinciasPoblaciones.setLayout(new BorderLayout());

        panelProvincias.setLayout(new BorderLayout());
        panelProvincias.add(labelProvincias, BorderLayout.NORTH);
        panelProvincias.add(listProvincias, BorderLayout.CENTER);
        panelProvinciasPoblaciones.add(panelProvincias, BorderLayout.NORTH);

        panelPoblaciones.setLayout(new BorderLayout());
        panelPoblaciones.add(labelPoblaciones, BorderLayout.NORTH);
        panelPoblaciones.add(listPoblaciones, BorderLayout.CENTER);
        panelProvinciasPoblaciones.add(panelPoblaciones, BorderLayout.CENTER);

        add(panelProvinciasPoblaciones, BorderLayout.WEST);

        panelPredicciones.setLayout(new BorderLayout());
        panelPredicciones.add(labelPredicciones, BorderLayout.NORTH);
        panelPredicciones.add(listPredicciones, BorderLayout.CENTER);
        add(panelPredicciones, BorderLayout.CENTER);

        panelEstado.add(labelEventos);
        add(panelEstado, BorderLayout.SOUTH);
    }
}
