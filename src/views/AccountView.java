package views;

import java.awt.*;

import javax.swing.*;

import models.User;
import utils.AppFont;
import utils.Session;
import utils.ThemeManager;

public class AccountView extends JPanel {

    User user = Session.getCurrentUser();
	JButton btnTheme;

	public AccountView() {
		setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 245));

        datosUsuario();
		setMenu();
	}

    public void datosUsuario(){
        JPanel cuadroPrincipal = new JPanel();
        cuadroPrincipal.setLayout(new BoxLayout(cuadroPrincipal, BoxLayout.Y_AXIS));
        cuadroPrincipal.setBackground(Color.WHITE);
        cuadroPrincipal.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)), BorderFactory.createEmptyBorder(30, 40, 30, 40)));

        JLabel inicialUsuario = new JLabel(String.valueOf(user.getName().charAt(0)).toUpperCase());
        inicialUsuario.setFont(AppFont.large());
        inicialUsuario.setForeground(Color.WHITE);
        inicialUsuario.setBackground(new Color(0, 120, 215));
        inicialUsuario.setOpaque(true);
        inicialUsuario.setPreferredSize(new Dimension(70, 70));
        inicialUsuario.setMaximumSize(new Dimension(70, 70));
        inicialUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        inicialUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        cuadroPrincipal.add(inicialUsuario);
        cuadroPrincipal.add(Box.createVerticalStrut(15));

        JLabel lblRol = new JLabel(user.getRole().toUpperCase());
        lblRol.setFont(AppFont.medium());
        lblRol.setForeground(new Color(0, 120, 215));
        lblRol.setAlignmentX(Component.CENTER_ALIGNMENT);
        cuadroPrincipal.add(lblRol);
        cuadroPrincipal.add(Box.createVerticalStrut(20));


        cuadroPrincipal.add(crearFilaDato("Email", user.getEmail()));
        cuadroPrincipal.add(Box.createVerticalStrut(12));

        cuadroPrincipal.add(crearFilaDato("Teléfono", user.getPhone()));

        cuadroPrincipal.add(Box.createVerticalStrut(12));
        cuadroPrincipal.add(crearFilaDato("Rol", user.getRole()));

        JPanel contenedorPrincipal = new JPanel(new GridBagLayout());
        contenedorPrincipal.setBackground(Color.decode("#0F1524"));
        contenedorPrincipal.add(cuadroPrincipal);

        add(contenedorPrincipal, BorderLayout.CENTER);
    }

    private JPanel crearFilaDato(String nombre, String valor) {

        JPanel fila = new JPanel(new BorderLayout(10, 0));
        fila.setBackground(Color.WHITE);
        fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        JLabel lblNombre = new JLabel(nombre);
        lblNombre.setFont(AppFont.medium());
        lblNombre.setForeground(new Color(130, 130, 130));
        lblNombre.setPreferredSize(new Dimension(80, 20));

        JLabel lblValor = new JLabel(valor);
        lblValor.setFont(AppFont.medium());
        lblValor.setForeground(new Color(40, 40, 40));

        fila.add(lblNombre, BorderLayout.WEST);
        fila.add(lblValor, BorderLayout.CENTER);

        return fila;
    }


	public void setMenu() {
		JPanel panelMenu = new JPanel();
        panelMenu.setPreferredSize(new Dimension(0, 70));
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
        add(panelMenu, BorderLayout.NORTH);
        panelMenu.setBackground(Color.decode("#0F1524"));

		btnTheme = new JButton("Cambiar modo");
		btnTheme.setMaximumSize(new Dimension(120, 40));

	    btnTheme.addActionListener(e -> {
	    	ThemeManager.toggle();
	    });

	    panelMenu.add(btnTheme);
	}


}
