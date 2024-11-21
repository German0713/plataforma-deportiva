package com.plataformadeportiva.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.plataformadeportiva.auth.PasswordUtils;

public class InsertUser {

    // Método para insertar usuario
    public void insertUser(String username, String plainPassword, String email) {
        // Hash de la contraseña
        String hashedPassword = PasswordUtils.hashPassword(plainPassword);

        // Consulta para insertar un nuevo usuario
        String query = "INSERT INTO usuarios (nombre_usuario, contrasena, correo) VALUES (?, ?, ?)";

        // Manejo de excepciones mejorado y control de posibles duplicados
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Asegúrate de que la conexión esté en autocommit
            connection.setAutoCommit(true); // Esto asegura que los cambios se guarden automáticamente

            // Establecer los parámetros de la consulta
            statement.setString(1, username);
            statement.setString(2, hashedPassword);
            statement.setString(3, email);

            // Ejecutar la consulta de inserción
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario registrado exitosamente con contraseña encriptada.");
            } else {
                System.out.println("No se pudo registrar el usuario.");
            }
            
        } catch (SQLException e) {
            // Manejo específico de excepciones de SQL
            if (e.getSQLState().equals("23505")) { // Código de error para violación de restricción de unicidad (clave duplicada)
                System.out.println("Error: El correo ya está registrado.");
            } else {
                System.out.println("Error al registrar usuario: " + e.getMessage());
            }
        } catch (Exception e) {
            // Manejo general de excepciones
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    // Método main (opcional, para pruebas directas)
    public static void main(String[] args) {
        InsertUser insertUser = new InsertUser();
        insertUser.insertUser("germangarcia", "3125542155", "ggarciagar2@uniminuto.edu.co");
    }
}

