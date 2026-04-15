package controllers;

import excepciones.InvalidRegisterEmailException;
import excepciones.InvalidRegisterPasswordException;
import models.User;
import views.FormUserView;
import views.LoginWindow;
import views.mainWindow;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;

public class RegisterController {

    private FormUserView view;

    public  RegisterController(FormUserView view){
        this.view = view;
        registrarListeners();

    }


    private void registrarListeners(){

        view.getBtnRegistro().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controlRegistro();
            }
        });

        //view.getBtnRegistro().addActionListener(e -> controlRegistro() );

        view.getBtnCancelar().addActionListener(e -> handleRegistration());

        view.getBtnCancelar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleRegistration();
            }
        });

        view.getTxtNombre().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarNombre();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarNombre();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarNombre();
            }
        });

        view.getTxtEmail().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    validarEmail();
                } catch (InvalidRegisterEmailException ex) {
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    validarEmail();
                } catch (InvalidRegisterEmailException ex) {
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    validarEmail();
                } catch (InvalidRegisterEmailException ex) {
                }
            }
        });

        view.getJpfContrasena().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarContrasena();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarContrasena();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarContrasena();
            }
        });

        view.getJpfConfirmarContrasena().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    validarConfirmarContrasena();
                } catch (InvalidRegisterPasswordException ex) {

                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    validarConfirmarContrasena();
                } catch (InvalidRegisterPasswordException ex) {
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    validarConfirmarContrasena();
                } catch (InvalidRegisterPasswordException ex) {

                }
            }
        });

        view.getTxtNombre().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isDigit(e.getKeyChar()) || !Character.isAlphabetic(e.getKeyChar())){
                    e.consume();
                }

                if (view.getTxtNombre().getText().length() >= 25){
                    e.consume();
                }

            }
        });

        view.getTxtNombre().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                view.getTxtNombre().selectAll();
            }
        });

    }

    private void controlRegistro(){

        try{
            if(validarCredenciales()){
                JOptionPane.showMessageDialog(view, "Se creo la cuenta", "Cuenta creada", JOptionPane.INFORMATION_MESSAGE);

                new mainWindow();
                view.getWindow().dispose();

                User user = new User(
                        view.getUserName(),
                        view.getEmail()
                );

                System.out.println(user);
                System.out.println("Guardado");
            }
        }catch (InvalidRegisterEmailException ex){
            view.getLblEmailRequerido().setText("Falta @ en el email");
        }catch (InvalidRegisterPasswordException ex){
            view.getLblConfirmarContrasena().setText("Las contraseñas deben coincidir");
        }
    }

    //Metodo que crea y abre un nuevo Jframe
    public void handleRegistration() {
        new LoginController(new LoginWindow().getLoginView());
        view.getWindow().dispose();
    }

    private boolean validarNombre(){

        if(view.getTxtNombre().getText().trim().isEmpty()){
            view.getLblNombreRequerido().setText("El nombre es obligatorio");
            return false;
        }

        view.getLblNombreRequerido().setText("");

        return true;
    }

    private boolean validarEmail() throws InvalidRegisterEmailException {

        if (view.getTxtEmail().getText().trim().isEmpty()){
            view.getLblEmailRequerido().setText("El email es obligatorio");
            return false;
        }

        if (!view.getTxtEmail().getText().contains("@")){
            throw new InvalidRegisterEmailException("Falta arroba en el Email");
        }

        view.getLblEmailRequerido().setText("");

        return true;
    }

    private boolean validarContrasena(){
        if (String.valueOf(view.getJpfContrasena().getPassword()).trim().isEmpty()){
            view.getLblContrasenaRequerida().setText("La contraseña es obligatoria");
            return false;
        }

        view.getLblContrasenaRequerida().setText("");

        return true;
    }

    private boolean validarConfirmarContrasena() throws InvalidRegisterPasswordException {
        if (String.valueOf(view.getJpfConfirmarContrasena().getPassword()).trim().isEmpty()){
            view.getLblConfirmarContrasena().setText("Confirmar la contraseña es obligatorio");
            return false;
        }

        if (!String.valueOf(view.getJpfContrasena().getPassword()).equals(String.valueOf(view.getJpfConfirmarContrasena().getPassword()))){
            throw new InvalidRegisterPasswordException("Las contraseñas no coinciden");
        }

        view.getLblConfirmarContrasena().setText("");

        return true;
    }

    private boolean validarCheckTerminos(){

        if (!view.getCheckTerminos().isSelected()){
            view.getLblCheckTerminosRequerido().setText("Necesita aceptar los terminos y condiciones");
            return false;
        }

        view.getLblCheckTerminosRequerido().setText("");

        return true;
    }

    private boolean validarCredenciales() throws InvalidRegisterEmailException, InvalidRegisterPasswordException {

        boolean validar = true;

        if (!validarNombre()){
            validar = false;
        }

        if (!validarEmail()){
            validar = false;
        }

        if (!validarContrasena()){
            validar = false;
        }

        if (!validarConfirmarContrasena()){
            validar = false;
        }

        if(!validarCheckTerminos()){
            validar = false;
        }

        return validar;
    }


}
