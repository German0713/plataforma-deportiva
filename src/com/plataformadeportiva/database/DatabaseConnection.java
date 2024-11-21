package com.plataformadeportiva.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        // Configura la URL de tu base de datos, usuario y contraseña
        String url = "jdbc:postgresql://localhost:5432/plataforma_deportiva";
        String user = "postgres";  // Tu usuario de PostgreSQL
        String password = "1234";  // Tu contraseña de PostgreSQL
        
        // Intenta cargar el driver de PostgreSQL
        try {
            // Asegúrate de que el driver de PostgreSQL esté registrado
            Class.forName("org.postgresql.Driver");
            System.out.println("Conexión con la base de datos establecida.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de PostgreSQL: " + e.getMessage());
            throw new SQLException("No se pudo cargar el driver JDBC de PostgreSQL", e);
        }

        // Establece la conexión y la devuelve
        return DriverManager.getConnection(url, user, password);
    }
}
