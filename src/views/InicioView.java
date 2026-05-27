package views;

import com.mysql.cj.util.DnsSrv;
import repository.UserRepository;
import utils.AppFont;
import utils.SwingUtils;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;

public class InicioView extends JPanel {

    private final UserRepository userRepository;

    private JLabel lblTotalUsuariosNumero;
    private JLabel lblTotalUsuariosSubtitulo;

    public InicioView(UserRepository userRepository) {
        this.userRepository = userRepository;

        UIManager.put("Text.Component.arc", 10);
        UIManager.put("Button.arc", 10);
        setLayout(new BorderLayout());

        JPanel panelCards = new JPanel(new GridBagLayout());
        panelCards.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panelCards, BorderLayout.NORTH);

        lblTotalUsuariosNumero  = new JLabel("...");
        lblTotalUsuariosSubtitulo  = new JLabel("cargando...");

        panelCards.add(crearTarjeta("Total usuarios",lblTotalUsuariosSubtitulo,lblTotalUsuariosNumero ), SwingUtils.crearGBC(0, 0, 1.0, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        panelCards.add(crearTarjeta("Total Libros", new JLabel("copias totales"), new JLabel("30")), SwingUtils.crearGBC(1, 0, 1.0, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        panelCards.add(crearTarjeta("Total solicitudes", new JLabel("copias totales"), new JLabel("30")), SwingUtils.crearGBC(2, 0, 1.0, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        panelCards.add(crearTarjeta("Status libros", new JLabel("copias totales"), new JLabel("30")), SwingUtils.crearGBC(3, 0, 1.0, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        cargarDatosUsers();
	}

    private JPanel crearTarjeta(String titulo, JLabel lblsubtitulo, JLabel lblnumero){
        JPanel card = new JPanel(new BorderLayout(5, 5));
        card.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)), BorderFactory.createEmptyBorder(12, 15, 12, 15)));
        card.setBackground(Color.WHITE);

        // Fila superior: título + número
        JPanel filaSuperior = new JPanel(new BorderLayout());
        filaSuperior.setBackground(Color.WHITE);

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(AppFont.medium());
        lblTitulo.setForeground(new Color(100, 100, 100));

        lblnumero.setFont(AppFont.medium());
        lblnumero.setForeground(new Color(0, 120, 215));
        lblnumero.setHorizontalAlignment(SwingConstants.RIGHT);

        filaSuperior.add(lblTitulo, BorderLayout.WEST);
        filaSuperior.add(lblnumero, BorderLayout.EAST);

        lblsubtitulo.setFont(AppFont.medium());
        lblsubtitulo.setForeground(new Color(150, 150, 150));

        card.add(filaSuperior, BorderLayout.CENTER);
        card.add(lblsubtitulo, BorderLayout.SOUTH);

        return card;
    }

    private void cargarDatosUsers(){
        try{
            int totalUsers = userRepository.count();
            lblTotalUsuariosNumero.setText(String.valueOf(totalUsers));
            lblTotalUsuariosSubtitulo.setText(totalUsers + " aprovados");
        }catch (Exception ex) {
            lblTotalUsuariosNumero.setText("N/A");
            lblTotalUsuariosNumero.setText("Error al cargar");
            ex.printStackTrace();
        }
    }

    public void refresh(){
        cargarDatosUsers();
    }
}
