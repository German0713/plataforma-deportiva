package com.plataformadeportiva.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.plataformadeportiva.auth.Login;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginForm() {
        setTitle("Inicio de Sesión");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Crear los componentes
        JLabel usernameLabel = new JLabel("Nombre de Usuario:");
        JLabel passwordLabel = new JLabel("Contraseña:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Iniciar Sesión");

        // Acción al hacer clic en el botón de inicio de sesión
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Validar las credenciales
                Login login = new Login();
                if (login.authenticate(username, password)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
                    // Aquí puedes redirigir al usuario a otra ventana si es necesario
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
                }
            }
        });

        // Añadir los componentes al formulario
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel());  // Espacio vacío
        add(loginButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
