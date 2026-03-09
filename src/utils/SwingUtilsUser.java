package utils;

import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import components.TextPrompt;

public class SwingUtilsUser {

    public static void configurarComponente(int largo, int ancho, String prompt, JTextComponent tipoComponente){

        tipoComponente.setMaximumSize(new Dimension(Integer.MAX_VALUE, ancho));
        new TextPrompt(prompt, tipoComponente);
    }
}
