package com.plataformadeportiva.auth;

public class TestLogin {
    public static void main(String[] args) {
        // Crear una instancia de Login
        Login login = new Login();

        // Probar las credenciales registradas
        if (login.authenticate("admin", "12345")) {
            System.out.println("Inicio de sesión exitoso.");
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }
}
