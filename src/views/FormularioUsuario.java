package views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormularioUsuario extends JPanel {
	
	FormularioWindowUsuario window;

    public FormularioUsuario(FormularioWindowUsuario window){
    	this.window = window;
        setLayout(new BorderLayout());
        Border emptyBorder = BorderFactory.createEmptyBorder(20,10,20,10);

        panelSuperior();
        panelCentral();
        panelInferior();
    }

    public void panelSuperior(){
        JPanel panelVerticalSuperior = new JPanel();
        panelVerticalSuperior.setLayout(new BoxLayout(panelVerticalSuperior, BoxLayout.Y_AXIS));
        Border emptyBorder = BorderFactory.createEmptyBorder(20,10,40,10);
        setBorder(emptyBorder);

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

        JPanel panelHorizontal = new JPanel();
        panelHorizontal.setLayout(new BoxLayout(panelHorizontal, BoxLayout.X_AXIS));
        panelVertical.add(panelHorizontal);

        Border emptyBorder = BorderFactory.createEmptyBorder(20,10,20,10);
        setBorder(emptyBorder);

        //JPanel panel = new JPanel();
        //panel.add(Box.createVerticalGlue());

        JLabel lblname = new JLabel("Nombre(s): ");
        lblname .setAlignmentX(Component.CENTER_ALIGNMENT);
        panelHorizontal.add(lblname);

        JTextField txtnombre = new JTextField();
        txtnombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelHorizontal.add(txtnombre);
        txtnombre.setMaximumSize(new Dimension(200,30));

        JLabel lblApellidos = new JLabel("Apellidos: ");
        lblApellidos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelHorizontal.add(lblApellidos);

        JTextField txtApellidos = new JTextField();
        txtApellidos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelHorizontal.add(txtApellidos);
        txtApellidos.setMaximumSize(new Dimension(200,30));

        /*
        JLabel lblsegundoApellido = new JLabel("Segundo apellido: ");
        lblsegundoApellido.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelVertical.add(lblsegundoApellido);

        JTextField txtsegundoApellido = new JTextField();
        txtsegundoApellido.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelVertical.add(txtsegundoApellido);
        txtsegundoApellido.setMaximumSize(new Dimension(200,30));
        */

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panelVertical.add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelVertical.add(txtEmail);
        txtEmail.setMaximumSize(new Dimension(200,30));

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelVertical.add(lblContrasena);

        JPasswordField contrasena = new JPasswordField();
        contrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelVertical.add(contrasena);
        contrasena.setMaximumSize(new Dimension(200,30));

        JLabel lblConfirmarContrasena = new JLabel("Confirmar contraseña:");
        lblConfirmarContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelVertical.add(lblConfirmarContrasena);

        JPasswordField confirmarContrasena = new JPasswordField();
        confirmarContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelVertical.add(confirmarContrasena);
        confirmarContrasena.setMaximumSize(new Dimension(200,30));

        panelCentro.add(panelVertical, BorderLayout.CENTER);//Agrega el panel vertical al centro del border layout secundario.
        add(panelCentro, BorderLayout.CENTER);//Agrega el border layout secundario al centro del border layout principal

    }

    public void panelInferior(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel, BorderLayout.SOUTH);

        JCheckBox checkTerminos = new JCheckBox("Acepto los terminos de uso y la politca de privacidad");
        checkTerminos.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(checkTerminos);

        JButton registro = new JButton("Continuar");
        registro.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(registro);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCancelar.addActionListener(e -> handleRegistration());
        
        panel.add(btnCancelar);

    }
    
    public void handleRegistration() {
    	new LoginWindow();
    	window.dispose();
    	
    }


}
