package com.plataformadeportiva.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VerifyUser {
    public static void main(String[] args) {
        String query = "SELECT * FROM usuarios";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Mostrar los resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("nombre_usuario");
                String hashedPassword = resultSet.getString("contrasena");
                String email = resultSet.getString("correo");

                System.out.println("ID: " + id);
                System.out.println("Username: " + username);
                System.out.println("Hashed Password: " + hashedPassword);
                System.out.println("Email: " + email);
                System.out.println("------------------------");
            }

        } catch (Exception e) {
            System.out.println("Error al consultar usuarios: " + e.getMessage());
        }
    }
}
