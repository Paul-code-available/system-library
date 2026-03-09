package utils;

import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.JTextField;

import components.TextPrompt;

public class SwingUtils {

    public static JTextField crearJtf(int largo, int ancho, String prompt) {

        JTextField jtf = new JTextField();
        jtf.setMaximumSize(new Dimension(Integer.MAX_VALUE, ancho));
        TextPrompt promptNombre = new TextPrompt(prompt, jtf);

        return jtf;

    }


}