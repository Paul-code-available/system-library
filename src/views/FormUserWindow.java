package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.Normalizer;

public class FormUserWindow extends JFrame {

    private FormUserView formUserView;

    public FormUserWindow() {
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Registro de usuario");
        setLocationRelativeTo(null);
        setResizable(false);


        formUserView = new FormUserView(this);
        add(formUserView);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controlCerradoVentana();
            }
        });

    }

    public FormUserView getFormUserView() {
        return formUserView;
    }

    private void controlCerradoVentana(){
        int opcion = JOptionPane.showConfirmDialog(this, "Seguro que deseas cerrar la ventana? Se perderán todos los datos");

        if (opcion == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

}
