package views;

import javax.swing.*;
import java.awt.*;

public class FormUserWindow extends JFrame {


    public FormUserWindow(){
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registro de usuario");
        setLocationRelativeTo(null);

        FormUserView formularioUsuarios = new FormUserView(this);
        add(formularioUsuarios);

        setVisible(true);
    }


}
