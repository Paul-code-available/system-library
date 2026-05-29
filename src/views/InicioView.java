package views;

import com.itextpdf.commons.actions.AbstractProductProcessITextEvent;
import com.mysql.cj.util.DnsSrv;
import models.Prestamo;
import repository.*;
import utils.AppFont;
import utils.SwingUtils;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.sql.SQLException;
import java.util.Map;
import java.util.List;

public class InicioView extends JPanel {

    private final UserRepository userRepository;
    private final LibroRepository libroRepository;
    private final PrestamoRepository prestamoRepository;

    private JLabel lblTotalUsuariosNumero;
    private JLabel lblTotalUsuariosSubtitulo;

    private JLabel lblTotalLibrosNumero;
    private JLabel lblTotalLibrosSubtitulo;

    private JLabel lblTotalSolicitudesNumero;
    private JLabel lblTotalSolicitudesSubtitulo;
    private JLabel lblStatusLibrosNumero;
    private JLabel lblStatusLibrosSubtitulo;

    private JPanel panelCategorias;
    private JPanel panelPorAnio;
    private JPanel panelRecentBorrows;

    public InicioView(UserRepository userRepository, LibroRepository libroRepository, PrestamoRepository prestamoRepository) {
        this.userRepository = userRepository;
        this.libroRepository = libroRepository;
        this.prestamoRepository = prestamoRepository;

        UIManager.put("Text.Component.arc", 10);
        UIManager.put("Button.arc", 10);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //mainPanel.setBackground(Color.decode("#0F1524"));

        mainPanel.add(crearPanelTarjetas());
        mainPanel.add(Box.createVerticalStrut(15));

        mainPanel.add(crearFilaMedia());
        mainPanel.add(Box.createVerticalStrut(15));

        mainPanel.add(crearFilaInferior());

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        cargarDatosUsers();
        cargarDatosLibros();
        cargarDatosSolicitudes();
	}

    private JPanel crearPanelTarjetas(){
        JPanel panel = new JPanel(new GridLayout(1, 4, 10, 0));

        lblTotalUsuariosNumero    = new JLabel("...");
        lblTotalUsuariosSubtitulo = new JLabel("cargando...");

        lblTotalLibrosNumero    = new JLabel("...");
        lblTotalLibrosSubtitulo = new JLabel("cargando...");

        lblTotalSolicitudesNumero    = new JLabel("...");
        lblTotalSolicitudesSubtitulo = new JLabel("cargando...");

        lblStatusLibrosNumero    = new JLabel("...");
        lblStatusLibrosSubtitulo = new JLabel("cargando...");

        panel.add(crearTarjeta("Total usuarios", lblTotalUsuariosSubtitulo, lblTotalUsuariosNumero));
        panel.add(crearTarjeta("Total libros", lblTotalLibrosSubtitulo, lblTotalLibrosNumero));
        panel.add(crearTarjeta("Total solicitudes", lblTotalSolicitudesSubtitulo, lblTotalSolicitudesNumero));
        panel.add(crearTarjeta("Estatus libros", lblStatusLibrosSubtitulo, lblStatusLibrosNumero));

        return panel;
    }


    private JPanel crearTarjeta(String titulo, JLabel lblsubtitulo, JLabel lblnumero){
        JPanel card = new JPanel(new BorderLayout(5, 5));
        card.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(220, 220, 220, 0)), BorderFactory.createEmptyBorder(12, 15, 12, 15)));
        card.setBackground(Color.decode("#0F1524"));

        JPanel filaSuperior = new JPanel(new BorderLayout());
        filaSuperior.setBackground(Color.decode("#0F1524"));

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(AppFont.medium());
        lblTitulo.setForeground(Color.WHITE);

        lblnumero.setFont(AppFont.medium());
        lblnumero.setForeground(Color.WHITE);
        lblnumero.setHorizontalAlignment(SwingConstants.RIGHT);

        filaSuperior.add(lblTitulo, BorderLayout.WEST);
        filaSuperior.add(lblnumero, BorderLayout.EAST);

        lblsubtitulo.setFont(AppFont.medium());
        lblsubtitulo.setForeground(Color.WHITE);

        card.add(filaSuperior, BorderLayout.CENTER);
        card.add(lblsubtitulo, BorderLayout.SOUTH);

        return card;
    }

    private JPanel crearFilaMedia() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 0));
        panel.add(crearPanelDisponibilidad());
        panelRecentBorrows = crearPanelRecentBorrows();
        panel.add(panelRecentBorrows);

        return panel;
    }

    private JPanel crearPanelDisponibilidad() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#0F1524"));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel("Disponibilidad de libros");
        titulo.setFont(AppFont.large());
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(titulo, BorderLayout.NORTH);

        JPanel contenido = new JPanel();
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
        contenido.setBackground(Color.decode("#0F1524"));

        int disponibles = libroRepository.contarCopiasDisponibles();
        int prestados = libroRepository.totalCopiasPrestadas();
        int total = disponibles + prestados;

        contenido.add(crearFilaDisponibilidad("Copias disponibles", disponibles, total, new Color(47, 169, 89)));
        contenido.add(Box.createVerticalStrut(15));
        contenido.add(crearFilaDisponibilidad("Copias prestadas",   prestados,   total, new Color(0, 89, 155)));

        panel.add(contenido, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearFilaDisponibilidad(String label, int valor, int total, Color color) {
        JPanel panel = new JPanel(new BorderLayout(0, 4));
        panel.setBackground(Color.decode("#0F1524"));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        JPanel filaNums = new JPanel(new BorderLayout());
        filaNums.setBackground(Color.decode("#0F1524"));

        JLabel lbl = new JLabel(label);
        lbl.setFont(AppFont.medium());
        lbl.setForeground(Color.WHITE);

        JLabel num = new JLabel(String.valueOf(valor));
        num.setFont(AppFont.medium());
        num.setHorizontalAlignment(SwingConstants.RIGHT);
        num.setForeground(Color.WHITE);

        filaNums.add(lbl, BorderLayout.WEST);
        filaNums.add(num, BorderLayout.EAST);

        panel.add(filaNums, BorderLayout.NORTH);
        panel.add(crearProgressBar(valor, total, color, 5), BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelRecentBorrows() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#0F1524"));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel("Préstamos recientes");
        titulo.setFont(AppFont.large());
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(titulo, BorderLayout.NORTH);

        JPanel lista = new JPanel();
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));
        lista.setBackground(Color.decode("#0F1524"));

        List<Prestamo> recientes = prestamoRepository.getRecentPrestamos(5);

        for (Prestamo p : recientes) {
            lista.add(crearFilaPrestamo(p));
            lista.add(Box.createVerticalStrut(8));
        }

        panel.add(lista, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearFilaPrestamo(Prestamo p) {
        JPanel fila = new JPanel(new BorderLayout());
        fila.setBackground(Color.decode("#0F1524"));
        fila.setBorder(BorderFactory.createEmptyBorder(4, 0, 4, 0));

        JPanel izq = new JPanel(new GridLayout(2, 1));
        izq.setBackground(Color.decode("#0F1524"));

        JLabel titulo = new JLabel(p.getLibro().getTitle());
        titulo.setFont(AppFont.medium());
        titulo.setForeground(Color.WHITE);

        JLabel usuario = new JLabel("por " + p.getUser().getName());
        usuario.setFont(AppFont.medium());
        usuario.setForeground(Color.WHITE);

        izq.add(titulo);
        izq.add(usuario);

        String estado = p.getEstado();
        Color badgeColor = estado.equalsIgnoreCase("activo")   ? new Color(0, 150, 100) :
                estado.equalsIgnoreCase("vencido")  ? new Color(200, 50, 50) : new Color(100, 100, 200);

        JLabel badge = new JLabel(estado.toUpperCase());
        badge.setFont(AppFont.medium());
        badge.setForeground(badgeColor);
        badge.setHorizontalAlignment(SwingConstants.RIGHT);

        fila.add(izq,   BorderLayout.WEST);
        fila.add(badge, BorderLayout.EAST);

        return fila;
    }

    private JPanel crearFilaInferior() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 0));

        panelCategorias = crearPanelCategorias();
        panelPorAnio = crearPanelPorAnio();
        panel.add(panelCategorias);
        panel.add(panelPorAnio);
        return panel;
    }

    private JPanel crearPanelCategorias() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#0F1524"));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel("Categorías de libros");
        titulo.setFont(AppFont.large());
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(titulo, BorderLayout.NORTH);

        JPanel lista = new JPanel();
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));
        lista.setBackground(Color.decode("#0F1524"));

        Map<String, Integer> categorias = libroRepository.totalLibrosCategoria();
        int totalLibros = libroRepository.count();

        Color[] colores = {
                new Color(100, 80, 220),
                new Color(0, 180, 100),
                new Color(0, 120, 215),
                new Color(255, 140, 0),
                new Color(200, 50, 150)
        };

        int i = 0;
        for (Map.Entry<String, Integer> entry : categorias.entrySet()) {
            Color color = colores[i % colores.length];
            lista.add(crearFilaCategoria(entry.getKey(), entry.getValue(), totalLibros, color));
            lista.add(Box.createVerticalStrut(12));
            i++;
        }

        panel.add(lista, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearFilaCategoria(String nombre, int cantidad, int total, Color color) {
        JPanel panel = new JPanel(new BorderLayout(0, 4));
        panel.setBackground(Color.decode("#0F1524"));

        JPanel filaInfo = new JPanel(new BorderLayout());
        filaInfo.setBackground(Color.decode("#0F1524"));

        JLabel lbl = new JLabel(nombre);
        lbl.setFont(AppFont.medium());
        lbl.setForeground(Color.WHITE);

        JLabel num = new JLabel(cantidad + " libros");
        num.setFont(AppFont.medium());
        num.setForeground(color);
        num.setHorizontalAlignment(SwingConstants.RIGHT);

        filaInfo.add(lbl, BorderLayout.WEST);
        filaInfo.add(num, BorderLayout.EAST);

        /*
        JProgressBar bar = new JProgressBar(0, Math.max(total, 1));
        bar.setValue(cantidad);
        bar.setForeground(color);
        bar.setBackground(new Color(230, 230, 230));
        bar.setPreferredSize(new Dimension(0, 5));
        bar.setBorderPainted(false);
         */

        JProgressBar bar = crearProgressBar(
                cantidad,
                total,
                color,
                5
        );

        panel.add(filaInfo, BorderLayout.NORTH);
        panel.add(bar,      BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelPorAnio() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#0F1524"));
        panel.setBorder( BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel("Libros por año de publicación");
        titulo.setFont(AppFont.large());
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(titulo, BorderLayout.NORTH);

        JPanel lista = new JPanel();
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));
        lista.setBackground(Color.decode("#0F1524"));

        Map<Integer, Integer> porAnio = libroRepository.totalLibrosYear();
        int maxVal = porAnio.values().stream().mapToInt(v -> v).max().orElse(1);

        for (Map.Entry<Integer, Integer> entry : porAnio.entrySet()) {
            lista.add(crearFilaAnio(entry.getKey(), entry.getValue(), maxVal));
            lista.add(Box.createVerticalStrut(12));
        }

        panel.add(lista, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearFilaAnio(int anio, int cantidad, int max) {
        JPanel panel = new JPanel(new BorderLayout(10, 0));
        panel.setBackground(Color.decode("#0F1524"));

        JLabel lblAnio = new JLabel(String.valueOf(anio));
        lblAnio.setFont(AppFont.medium());
        lblAnio.setForeground(Color.WHITE);
        lblAnio.setPreferredSize(new Dimension(40, 20));

        JProgressBar bar = crearProgressBar(cantidad, max, new Color(0, 180, 100), 4);

        JLabel lblCant = new JLabel(cantidad + " libros");
        lblCant.setFont(AppFont.medium());
        lblCant.setForeground(new Color(0, 180, 100));
        lblCant.setPreferredSize(new Dimension(65, 20));
        lblCant.setHorizontalAlignment(SwingConstants.RIGHT);

        panel.add(lblAnio, BorderLayout.WEST);
        panel.add(bar, BorderLayout.CENTER);
        panel.add(lblCant, BorderLayout.EAST);

        return panel;
    }

    private JProgressBar crearProgressBar(int valor, int maximo, Color color, int altura) {

        JProgressBar bar = new JProgressBar(0, Math.max(maximo, 1));
        bar.setValue(valor);
        bar.setForeground(color);
        bar.setBackground(new Color(230, 230, 230));
        bar.setBorderPainted(false);
        bar.setPreferredSize(new Dimension(0, altura));
        Dimension size = new Dimension(Integer.MAX_VALUE, altura);
        bar.setPreferredSize(size);
        bar.setMinimumSize(size);
        bar.setMaximumSize(size);

        return bar;
    }

    private void cargarDatosUsers(){
        try{
            int totalUsers = userRepository.count();
            lblTotalUsuariosNumero.setText(String.valueOf(totalUsers));
            lblTotalUsuariosSubtitulo.setText(totalUsers + " aprovados");
        }catch (Exception ex) {
            lblTotalUsuariosNumero.setText("N/A");
            lblTotalUsuariosSubtitulo.setText("Error al cargar");
            ex.printStackTrace();
        }
    }

    private void cargarDatosLibros(){
        try{
            int totalLibros = libroRepository.count();
            int totalCopiasLibros = libroRepository.countTotalCopias();
            lblTotalLibrosNumero.setText(String.valueOf(totalLibros));
            lblTotalLibrosSubtitulo.setText(totalCopiasLibros + " total copias");
        }catch (Exception ex){
            lblTotalLibrosNumero.setText("N/A");
            lblTotalLibrosSubtitulo.setText("Error al cargar");
            ex.printStackTrace();
        }
    }

    private void cargarDatosSolicitudes() {
        try {
            int total = prestamoRepository.count();
            int activos = prestamoRepository.countActivos();
            lblTotalSolicitudesNumero.setText(String.valueOf(total));
            lblTotalSolicitudesSubtitulo.setText(activos + " activos");

            int disponibles = libroRepository.contarCopiasDisponibles();
            lblStatusLibrosNumero.setText(String.valueOf(disponibles));
            lblStatusLibrosSubtitulo.setText(disponibles + " copias disponibles");
        } catch (Exception ex) {
            lblTotalSolicitudesNumero.setText("N/A");
            lblTotalSolicitudesSubtitulo.setText("Error al cargar");
            ex.printStackTrace();
        }
    }

    public void refresh(){
        cargarDatosUsers();
        cargarDatosLibros();
        cargarDatosSolicitudes();
    }
}
