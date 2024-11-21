package com.plataformadeportiva.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.plataformadeportiva.database.InsertUser;
import com.plataformadeportiva.auth.PasswordUtils;

public class RegisterUserForm extends JFrame {
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
                
    public RegisterUserForm() {
        setTitle("Formulario de Registro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Crear los componentes del formulario
        JLabel usernameLabel = new JLabel("Nombre de Usuario:");
        JLabel emailLabel = new JLabel("Correo Electrónico:");
        JLabel passwordLabel = new JLabel("Contraseña:");

        usernameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();

        JButton registerButton = new JButton("Registrar");

        // Acciones del botón de registro
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String email = emailField.getText();

                // Validación simple de los campos
                if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
                    return;
                }

                // Encriptar la contraseña
                String hashedPassword = PasswordUtils.hashPassword(password);

                // Crear una instancia de InsertUser y llamar al método insertUser
                InsertUser insertUser = new InsertUser();
                insertUser.insertUser(username, hashedPassword, email);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
            }
        });

        // Añadir los componentes al formulario
        add(usernameLabel);
        add(usernameField);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel());  // Espacio vacío
        add(registerButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterUserForm();
    }
}
