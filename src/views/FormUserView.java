package views;

import javax.imageio.spi.RegisterableService;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import utils.SwingUtilsUser;

public class FormUserView extends JPanel {

    FormUserWindow window;
    JTextField txtNombre;
    JTextField txtEmail;
    JPasswordField jpfContrasena;
    JPasswordField jpfConfirmarContrasena;
    JPasswordField jpfContrasenasDiferentes;
    JLabel lblNombreRequerido;
    JLabel lblEmailRequerido;
    JLabel lblContrasenaRequerida;
    JLabel lblConfirmarContrasena;
    JLabel lblContrasenasDiferentes;

    public FormUserView(FormUserWindow window){
        this.window = window;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

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
        Border emptyBorder = BorderFactory.createEmptyBorder(20,20,20,20);
        panelVerticalSuperior.setBorder(emptyBorder);

        JLabel lblSingUp = new JLabel("Sing up");
        lblSingUp.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelVerticalSuperior.add(lblSingUp);

        JLabel lblSingIn = new JLabel("Create an account or Sing in");
        lblSingIn.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelVerticalSuperior.add(lblSingIn);

        add(panelVerticalSuperior, BorderLayout.NORTH);
    }

    public void panelCentral(){

        JPanel panelCentro = new JPanel(new BorderLayout()); //se crea un Jpanel que despues se agregara dentro del layout principal y dentro de ese jpanel se agrega un Borderlayout.

        JPanel panelVertical = new JPanel();// se crea un Jpanel que despues de agregara dentro del centro del Borderlayout secundario.
        panelVertical.setLayout(new BoxLayout(panelVertical, BoxLayout.Y_AXIS));//Se define el panel vertical con un layout de tipo box.
        panelVertical.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelVertical.setBorder(BorderFactory.createEmptyBorder(20,30, 20, 30));
        panelVertical.setPreferredSize(new Dimension(350, 600));

        //JScrollPane barraScroll = new JScrollPane(panelVertical);
        //barraScroll.setHorizontalScrollBar(null);
        //add(panelCentro);

        JScrollPane barraScroll = new JScrollPane(panelVertical);
        barraScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        barraScroll.setBorder(null);
        barraScroll.getViewport().setBackground(panelVertical.getBackground());
        panelCentro.add(barraScroll, BorderLayout.CENTER);

        /*
        JPanel panelHorizontal = new JPanel();
        panelHorizontal.setLayout(new BoxLayout(panelHorizontal, BoxLayout.X_AXIS));
        panelVertical.add(panelHorizontal);
        panelHorizontal.setMaximumSize(new Dimension(350,40));
        */
        //Border emptyBorder = BorderFactory.createEmptyBorder(20,10,20,10);
        //setBorder(emptyBorder);

        txtNombre = new JTextField();
        SwingUtilsUser.configurarComponente(0, 40, "Nombre(s)", txtNombre);
        txtNombre.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelVertical.add(txtNombre);
        // panelHorizontal.add(Box.createHorizontalStrut(20)); //agrega un espacio horizontal de 10px entre un componente y otro dentro de un borderlayout

        lblNombreRequerido = new JLabel("El nombre es requerido.");
        lblNombreRequerido.setFont(new Font("Arial", Font.BOLD, 10));
        lblNombreRequerido.setForeground(Color.RED);
        lblNombreRequerido.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelVertical.add(lblNombreRequerido);
        panelVertical.add(Box.createVerticalStrut(20));

        /*
        txtApellido = new JTextField();
        SwingUtilsUser.configurarComponente(170, 40, "Apellidos", txtApellido);
        txtApellido.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelHorizontal.add(txtApellido);

        lblApellidoRequerido = new JLabel("El apellido es requerido.");
        lblApellidoRequerido.setFont(new Font("Arial", Font.BOLD, 10));
        lblApellidoRequerido.setForeground(Color.RED);
        lblApellidoRequerido.setVisible(false);
        panelHorizontal.add(lblApellidoRequerido);
        */

        txtEmail = new JTextField();
        SwingUtilsUser.configurarComponente(0, 40, "Email", txtEmail);
        txtEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelVertical.add(txtEmail);


        lblEmailRequerido = new JLabel("El email es requerido.");
        lblEmailRequerido.setFont(new Font("Arial", Font.BOLD, 10));
        lblEmailRequerido.setForeground(Color.RED);
        panelVertical.add(lblEmailRequerido);
        panelVertical.add(Box.createVerticalStrut(20));
        lblEmailRequerido.setAlignmentX(Component.LEFT_ALIGNMENT);

        jpfContrasena = new JPasswordField();
        SwingUtilsUser.configurarComponente(350, 40, "Contraseña", jpfContrasena);
        jpfContrasena.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelVertical.add(jpfContrasena);


        lblContrasenaRequerida = new JLabel("La contraseña es requerida.");
        lblContrasenaRequerida.setFont(new Font("Arial", Font.BOLD, 10));
        lblContrasenaRequerida.setForeground(Color.RED);
        panelVertical.add(lblContrasenaRequerida);
        panelVertical.add(Box.createVerticalStrut(20));
        lblContrasenaRequerida.setAlignmentX(Component.LEFT_ALIGNMENT);

        jpfConfirmarContrasena = new JPasswordField();
        SwingUtilsUser.configurarComponente(350, 40, "Confirmar contraseña", jpfConfirmarContrasena);
        jpfConfirmarContrasena .setAlignmentX(Component.LEFT_ALIGNMENT);
        panelVertical.add(jpfConfirmarContrasena );

        lblConfirmarContrasena = new JLabel("Confirmar la contraseña es requerido.");
        lblConfirmarContrasena.setFont(new Font("Arial", Font.BOLD, 10));
        lblConfirmarContrasena.setForeground(Color.RED);
        panelVertical.add(lblConfirmarContrasena);
        lblConfirmarContrasena.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblContrasenasDiferentes = new JLabel("Las contraseñas deben coincidir");
        lblContrasenasDiferentes.setFont(new Font("Arial", Font.BOLD, 10));
        lblContrasenasDiferentes.setForeground(Color.RED);
        panelVertical.add(lblContrasenasDiferentes);
        lblContrasenasDiferentes.setAlignmentX(Component.LEFT_ALIGNMENT);


        //panelCentro.add(panelVertical, BorderLayout.CENTER);//Agrega el panel vertical al centro del border layout secundario.
        add(panelCentro, BorderLayout.CENTER);//Agrega el border layout secundario al centro del border layout principal

    }

    public void panelInferior(){
        JPanel panelVertical = new JPanel();
        panelVertical.setLayout(new BoxLayout(panelVertical, BoxLayout.Y_AXIS));
        add(panelVertical, BorderLayout.SOUTH);

        JCheckBox checkTerminos = new JCheckBox("Acepto los terminos de uso y la politca de privacidad");
        panelVertical.add(checkTerminos);
        checkTerminos.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelVertical.add(Box.createVerticalStrut(30));

        JPanel panelHorizontal  = new JPanel();
        panelHorizontal.setLayout(new BoxLayout(panelHorizontal, BoxLayout.X_AXIS));
        panelVertical.add(panelHorizontal);

        JButton registro = new JButton("Continuar");
        registro.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelHorizontal.add(registro);
        panelHorizontal.add(Box.createHorizontalStrut(10));

        registro.addActionListener(e -> controlRegistro() );

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCancelar.addActionListener(e -> handleRegistration());
        panelHorizontal.add(btnCancelar);

        panelVertical.add(Box.createVerticalStrut(20));
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

        if (String.valueOf(jpfContrasena.getPassword()).equals(String.valueOf(jpfConfirmarContrasena.getPassword()))){
            lblConfirmarContrasena.setText("Las contraseñas deben coincidir");
            return false;
        }

        lblConfirmarContrasena.setText("");

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
