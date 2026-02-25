package views;

import javax.swing.*;

public class FormularioWindowUsuario extends JFrame {


    public FormularioWindowUsuario(){
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registro de usuario");
        setLocationRelativeTo(null);

        FormularioUsuario formularioUsuarios = new FormularioUsuario();

        setVisible(true);
        add(formularioUsuarios);
    }


}
