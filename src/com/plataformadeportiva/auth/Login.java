package com.plataformadeportiva.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.plataformadeportiva.database.DatabaseConnection;  // Asegúrate de tener esta clase para la conexión

public class Login {

    // Método para autenticar a un usuario
    public boolean authenticate(String username, String password) {
        // Consulta SQL para obtener la contraseña hasheada del usuario
        String query = "SELECT contrasena FROM usuarios WHERE nombre_usuario = ?";
        
        try (Connection connection = DatabaseConnection.getConnection();  // Obtén la conexión de la base de datos
             PreparedStatement statement = connection.prepareStatement(query)) {  // Prepara la sentencia SQL

            statement.setString(1, username);  // Establece el parámetro del nombre de usuario

            // Ejecuta la consulta y obtiene el resultado
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {  // Si se encuentra un usuario con ese nombre
                String hashedPassword = resultSet.getString("contrasena");  // Obtiene la contraseña hasheada
                return PasswordUtils.checkPassword(password, hashedPassword);  // Verifica si la contraseña ingresada coincide
            }
            
            return false; // Si no se encuentra el usuario, devuelve falso
        } catch (Exception e) {
            System.out.println("Error durante la autenticación: " + e.getMessage());
            return false;  // En caso de error, devuelve falso
        }
    }
}
