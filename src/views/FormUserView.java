package views;

import javax.imageio.spi.RegisterableService;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

import utils.AppFont;
import utils.SwingUtilsUser;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class FormUserView extends JPanel {

    FormUserWindow window;
    JTextField txtNombre;
    JTextField txtEmail;
    JPasswordField jpfContrasena;
    JPasswordField jpfConfirmarContrasena;
    JLabel lblNombreRequerido;
    JLabel lblEmailRequerido;
    JLabel lblContrasenaRequerida;
    JLabel lblConfirmarContrasena;
    JLabel lblContrasenasDiferentes;
    Color defaultButtonColor;

    public FormUserView(FormUserWindow window){
        this.window = window;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5,20,5,20));


        UIManager.put("Text.Component.arc", 10);
        UIManager.put("Button.arc", 10);

        panelSuperior();
        panelCentral();
        panelInferior();

        asignarListeners();
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
        //panelVerticalSuperior.add(lblRegistrarse);

        JPanel pnlMensajeInformacion = new JPanel();
        panelVerticalSuperior.add(pnlMensajeInformacion);

        JLabel lblMensajeInformativo = new JLabel("Crear una cuenta o iniciar sesión");
        lblMensajeInformativo.setFont(AppFont.small());
        lblMensajeInformativo.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlMensajeInformacion.add(lblMensajeInformativo);
        //panelVerticalSuperior.add(lblMensajeInformativo);

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
        // panelHorizontal.add(Box.createHorizontalStrut(20)); //agrega un espacio horizontal de 10px entre un componente y otro dentro de un borderlayout

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
        panelVertical.add(Box.createVerticalStrut(20));
        lblEmailRequerido.setAlignmentX(Component.LEFT_ALIGNMENT);


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
        JCheckBox checkTerminos = new JCheckBox("Acepto los terminos de uso y la politca de privacidad");
        panelVertical.add(checkTerminos);
        checkTerminos.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelVertical.add(Box.createVerticalStrut(15));

        JPanel panelHorizontal  = new JPanel();
        panelHorizontal.setLayout(new BoxLayout(panelHorizontal, BoxLayout.X_AXIS));
        panelVertical.add(panelHorizontal);

        JButton btnregistro = new JButton("Continuar");
        btnregistro.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnregistro.addActionListener(e -> controlRegistro() );
        btnregistro.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnregistro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleRegistration();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cambiarFondo(btnregistro);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                resetFondo(btnregistro);
            }
        });
        panelHorizontal.add(btnregistro);

        panelHorizontal.add(Box.createHorizontalStrut(10));


        JButton btnCancelar = new JButton("Cancelar");
        defaultButtonColor = btnCancelar.getBackground();
        btnCancelar.setAlignmentX(Component.LEFT_ALIGNMENT);
        //btnCancelar.addActionListener(e -> handleRegistration());
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleRegistration();
            }

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

    private void controlRegistro(){

        if(validarCredenciales()){
            JOptionPane.showMessageDialog(this, "Se creo la cuenta", "Cuenta creada", JOptionPane.INFORMATION_MESSAGE);

            new mainWindow();
            window.dispose();
        }
    }

    //Metodo que crea y abre un nuevo Jframe
    public void handleRegistration() {
        new LoginWindow();
        window.dispose();
    }

    private void asignarListeners(){

        txtNombre.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarNombre();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarNombre();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarNombre();
            }
        });

        txtEmail.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarEmail();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarEmail();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarEmail();
            }
        });

        jpfContrasena.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarContrasena();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarContrasena();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarContrasena();
            }
        });

        jpfConfirmarContrasena.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarConfirmarContrasena();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarConfirmarContrasena();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarConfirmarContrasena();
            }
        });

        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isDigit(e.getKeyChar()) || !Character.isAlphabetic(e.getKeyChar())){
                        e.consume();
                }

                if (txtNombre.getText().length() >= 25){
                    e.consume();
                }

            }
        });

        txtNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtNombre.selectAll();
            }
        });

    }

    private void cerrarVentana() {
        int opcion = JOptionPane.showConfirmDialog(this, "Seguro que deseas cerrar el programa");

        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private boolean validarNombre(){

        if(txtNombre.getText().trim().isEmpty()){
            lblNombreRequerido.setText("El nombre es obligatorio");
            return false;
        }

        lblNombreRequerido.setText("");

        return true;
    }

    private boolean validarEmail(){

        if (txtEmail.getText().trim().isEmpty()){
            lblEmailRequerido.setText("El email es obligatorio");
            return false;
        }

        if (!txtEmail.getText().contains("@")){
            lblEmailRequerido.setText("Falta '@' en el email");
        }

        lblEmailRequerido.setText("");

        return true;
    }

    private boolean validarContrasena(){
        if (String.valueOf(jpfContrasena.getPassword()).trim().isEmpty()){
            lblContrasenaRequerida.setText("La contraseña es obligatoria");
            return false;
        }

        lblContrasenaRequerida.setText("");

        return true;
    }

    private boolean validarConfirmarContrasena(){
        if (String.valueOf(jpfConfirmarContrasena.getPassword()).trim().isEmpty()){
            lblConfirmarContrasena.setText("Confirmar la contraseña es obligatorio");
            return false;
        }

        if (!String.valueOf(jpfContrasena.getPassword()).equals(String.valueOf(jpfConfirmarContrasena.getPassword()))){
            lblConfirmarContrasena.setText("Las contraseñas deben coincidir");
            return false;
        }

        lblConfirmarContrasena.setText("");
        lblContrasenasDiferentes.setText("");

        return true;
    }

    private boolean validarCheckTerminos(){

        return true;
    }

    private boolean validarCredenciales(){

        boolean validar = true;

        if (!validarNombre()){
            validar = false;
        }

        if (!validarEmail()){
            validar = false;
        }

        if (!validarContrasena()){
            validar = false;
        }

        if (!validarConfirmarContrasena()){
            validar = false;
        }

        return validar;
    }

}
