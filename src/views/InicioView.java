package views;

import java.awt.*;

import javax.swing.*;

public class InicioView extends JPanel {

	public InicioView() {

        JPanel panel = new JPanel(new GridBagLayout());

		GridBagConstraints gbcLblTotalUsers = new GridBagConstraints();
        gbcLblTotalUsers.gridx = 0;
        gbcLblTotalUsers.gridy = 0;
        gbcLblTotalUsers.fill = GridBagConstraints.EAST; //donde se anclara si no se llena la celda
        gbcLblTotalUsers.insets = new Insets(3, 3, 3, 3);
        panel.add(new JTextField("Total users: 2"), gbcLblTotalUsers);

        GridBagConstraints gbcLblTotalBooks = new GridBagConstraints();
        gbcLblTotalBooks.gridx = 1;
        gbcLblTotalBooks.gridy = 0;
        gbcLblTotalBooks.fill = GridBagConstraints.HORIZONTAL; //donde se anclara si no se llena la celda
        //gbcLblTotalBooks.weightx = 1.0;
        gbcLblTotalBooks.insets = new Insets(3, 3, 3, 3);
        panel.add(new JTextField("Total books: 20"), gbcLblTotalBooks);

        GridBagConstraints gbcLblTotalSolicitudes = new GridBagConstraints();
        gbcLblTotalSolicitudes.gridx = 2;
        gbcLblTotalSolicitudes.gridy = 0;
        gbcLblTotalSolicitudes.fill = GridBagConstraints.HORIZONTAL; //donde se anclara si no se llena la celda
        gbcLblTotalSolicitudes.weightx = 1.0;
        gbcLblTotalSolicitudes.insets = new Insets(3, 3, 3, 3);
        panel.add(new JTextField("Total solicitudes: 20"), gbcLblTotalSolicitudes);

        add(panel);
	}
}
