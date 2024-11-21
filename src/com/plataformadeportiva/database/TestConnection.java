package com.plataformadeportiva.database;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos.");
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
