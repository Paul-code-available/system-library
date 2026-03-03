package views;

import javax.swing.*;
import java.awt.*;

public class FormularioWindowUsuario extends JFrame {


    public FormularioWindowUsuario(){
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registro de usuario");
        setLocationRelativeTo(null);

        FormularioUsuario formularioUsuarios = new FormularioUsuario();
        add(formularioUsuarios);

        setVisible(true);
    }


}
