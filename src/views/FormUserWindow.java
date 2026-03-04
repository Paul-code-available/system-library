package views;

import javax.swing.*;

public class FormUserWindow extends JFrame {


    public FormUserWindow(){
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registro de usuario");
        setLocationRelativeTo(null);

        FormUserView formularioUsuarios = new FormUserView();
        add(formularioUsuarios);

        setVisible(true);
    }


}
