package views;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

import excepciones.InvalidRegisterEmailException;
import excepciones.InvalidRegisterPasswordException;
import utils.AppFont;
import utils.SwingUtilsUser;

public class FormUserView extends JPanel {

    private FormUserWindow window;
    private JTextField txtNombre;
    private  JTextField txtEmail;
    private JPasswordField jpfContrasena;
    private JPasswordField jpfConfirmarContrasena;
    private JLabel lblNombreRequerido;
    private JLabel lblEmailRequerido;
    private JLabel lblArrobaRequerido;
    private JLabel lblContrasenaRequerida;
    private JLabel lblConfirmarContrasena;
    private JLabel lblContrasenasDiferentes;
    Color defaultButtonColor;
    private JCheckBox checkTerminos;
    private JLabel lblCheckTerminosRequerido;
    private JButton btnRegistro;
    private JButton btnCancelar;


    public FormUserView(FormUserWindow window){
        this.window = window;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5,20,5,20));


        UIManager.put("Text.Component.arc", 10);
        UIManager.put("Button.arc", 10);

        panelSuperior();
        panelCentral();
        panelInferior();

        //asignarListeners();
    }

    public JCheckBox getCheckTerminos() {
        return checkTerminos;
    }

    public FormUserWindow getWindow() {
        return window;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JPasswordField getJpfContrasena() {
        return jpfContrasena;
    }

    public JPasswordField getJpfConfirmarContrasena() {
        return jpfConfirmarContrasena;
    }

    public JLabel getLblNombreRequerido() {
        return lblNombreRequerido;
    }

    public JLabel getLblEmailRequerido() {
        return lblEmailRequerido;
    }

    public JLabel getLblArrobaRequerido() {
        return lblArrobaRequerido;
    }

    public JLabel getLblContrasenaRequerida() {
        return lblContrasenaRequerida;
    }

    public JLabel getLblConfirmarContrasena() {
        return lblConfirmarContrasena;
    }

    public JLabel getLblContrasenasDiferentes() {
        return lblContrasenasDiferentes;
    }

    public JLabel getLblCheckTerminosRequerido() {
        return lblCheckTerminosRequerido;
    }

    public JButton getBtnRegistro() {
        return btnRegistro;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void panelSuperior(){
        JPanel panelVerticalSuperior = new JPanel();
        panelVerticalSuperior.setLayout(new BoxLayout(panelVerticalSuperior, BoxLayout.Y_AXIS));
        Border emptyBorder = BorderFactory.createEmptyBorder(0,20,8,20);
        panelVerticalSuperior.setBorder(emptyBorder);

        JPanel pnlTitulo = new JPanel();
        panelVerticalSuperior.add(pnlTitulo);

        JLabel lblRegistrarse = new JLabel("Registrarse");
        lblRegistrarse.setFont(AppFont.title());
        lblRegistrarse.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlTitulo.add(lblRegistrarse);

        JPanel pnlMensajeInformacion = new JPanel();
        panelVerticalSuperior.add(pnlMensajeInformacion);

        JLabel lblMensajeInformativo = new JLabel("Crear una cuenta o iniciar sesión");
        lblMensajeInformativo.setFont(AppFont.small());
        lblMensajeInformativo.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlMensajeInformacion.add(lblMensajeInformativo);

        add(panelVerticalSuperior, BorderLayout.NORTH);
    }

    public void panelCentral(){

        JPanel panelCentro = new JPanel(new BorderLayout()); //se crea un Jpanel que despues se agregara dentro del layout principal y dentro de ese jpanel se agrega un Borderlayout.

        JPanel panelVertical = new JPanel();// se crea un Jpanel que despues de agregara dentro del centro del Borderlayout secundario.
        panelVertical.setLayout(new BoxLayout(panelVertical, BoxLayout.Y_AXIS));//Se define el panel vertical con un layout de tipo box.
        panelVertical.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelVertical.setBorder(BorderFactory.createEmptyBorder(20,30, 20, 30));
        panelVertical.setPreferredSize(new Dimension(350, 600));

        JScrollPane barraScroll = new JScrollPane(panelVertical);
        barraScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        barraScroll.setBorder(null);
        barraScroll.getViewport().setBackground(panelVertical.getBackground());
        panelCentro.add(barraScroll, BorderLayout.CENTER);


        txtNombre = new JTextField();
        SwingUtilsUser.configurarComponente(0, 30, "Nombre(s)", txtNombre);
        txtNombre.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelVertical.add(txtNombre);

        lblNombreRequerido = new JLabel();
        lblNombreRequerido.setFont(AppFont.small());
        lblNombreRequerido.setForeground(Color.RED);
        lblNombreRequerido.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelVertical.add(lblNombreRequerido);
        panelVertical.add(Box.createVerticalStrut(20));


        txtEmail = new JTextField();
        SwingUtilsUser.configurarComponente(0, 30, "Email", txtEmail);
        txtEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelVertical.add(txtEmail);

        lblEmailRequerido = new JLabel();
        lblEmailRequerido.setFont(AppFont.small());
        lblEmailRequerido.setForeground(Color.RED);
        panelVertical.add(lblEmailRequerido);
        lblEmailRequerido.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblArrobaRequerido = new JLabel();
        lblArrobaRequerido.setFont(AppFont.small());
        lblArrobaRequerido.setForeground(Color.RED);
        panelVertical.add(lblArrobaRequerido);
        panelVertical.add(Box.createVerticalStrut(20));
        lblArrobaRequerido.setAlignmentX(Component.LEFT_ALIGNMENT);


        jpfContrasena = new JPasswordField();
        SwingUtilsUser.configurarComponente(350, 30, "Contraseña", jpfContrasena);
        jpfContrasena.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelVertical.add(jpfContrasena);

        lblContrasenaRequerida = new JLabel();
        lblContrasenaRequerida.setFont(AppFont.small());
        lblContrasenaRequerida.setForeground(Color.RED);
        panelVertical.add(lblContrasenaRequerida);
        panelVertical.add(Box.createVerticalStrut(20));
        lblContrasenaRequerida.setAlignmentX(Component.LEFT_ALIGNMENT);


        jpfConfirmarContrasena = new JPasswordField();
        SwingUtilsUser.configurarComponente(350, 30, "Confirmar contraseña", jpfConfirmarContrasena);
        jpfConfirmarContrasena .setAlignmentX(Component.LEFT_ALIGNMENT);
        panelVertical.add(jpfConfirmarContrasena );

        lblConfirmarContrasena = new JLabel();
        lblConfirmarContrasena.setFont(AppFont.small());
        lblConfirmarContrasena.setForeground(Color.RED);
        panelVertical.add(lblConfirmarContrasena);
        lblConfirmarContrasena.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblContrasenasDiferentes = new JLabel();
        lblContrasenasDiferentes.setFont(AppFont.small());
        lblContrasenasDiferentes.setForeground(Color.RED);
        panelVertical.add(lblContrasenasDiferentes);
        lblContrasenasDiferentes.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(panelCentro, BorderLayout.CENTER);//Agrega el border layout secundario al centro del border layout principal
    }

    public void panelInferior(){
        JPanel panelVertical = new JPanel();
        panelVertical.setLayout(new BoxLayout(panelVertical, BoxLayout.Y_AXIS));
        add(panelVertical, BorderLayout.SOUTH);

        panelVertical.add(Box.createVerticalStrut(5));
        checkTerminos = new JCheckBox("Acepto los terminos de uso y la politca de privacidad");
        panelVertical.add(checkTerminos);
        checkTerminos.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblCheckTerminosRequerido = new JLabel();
        lblCheckTerminosRequerido.setFont(AppFont.small());
        lblCheckTerminosRequerido.setForeground(Color.RED);
        panelVertical.add(lblCheckTerminosRequerido);
        lblCheckTerminosRequerido.setAlignmentX(LEFT_ALIGNMENT);
        panelVertical.add(Box.createVerticalStrut(15));

        JPanel panelHorizontal  = new JPanel();
        panelHorizontal.setLayout(new BoxLayout(panelHorizontal, BoxLayout.X_AXIS));
        panelVertical.add(panelHorizontal);

        btnRegistro = new JButton("Continuar");
        btnRegistro.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnRegistro.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnRegistro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cambiarFondo(btnRegistro);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                resetFondo(btnRegistro);
            }
        });
        panelHorizontal.add(btnRegistro);

        panelHorizontal.add(Box.createHorizontalStrut(10));


        btnCancelar = new JButton("Cancelar");
        defaultButtonColor = btnCancelar.getBackground();
        btnCancelar.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cambiarFondo(btnCancelar);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                resetFondo(btnCancelar);
            }
        });
        panelHorizontal.add(btnCancelar);

        panelVertical.add(Box.createVerticalStrut(10));
    }

    private void cambiarFondo(JComponent c){
        c.setBackground(Color.GRAY);
    }

    private void resetFondo(JComponent c){
        c.setBackground(defaultButtonColor);
    }

    private void cerrarVentana() {
        int opcion = JOptionPane.showConfirmDialog(this, "Seguro que deseas cerrar el programa");

        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

}
