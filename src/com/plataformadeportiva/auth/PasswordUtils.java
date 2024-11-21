package com.plataformadeportiva.auth;

import org.mindrot.jbcrypt.BCrypt;  // Asegúrate de tener esta dependencia en tu proyecto

public class PasswordUtils {

    // Genera un hash seguro para la contraseña
    public static String hashPassword(String password) {
        // Utiliza BCrypt para generar un salt y hashear la contraseña
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Verifica si la contraseña ingresada coincide con el hash almacenado
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        // Compara la contraseña ingresada con el hash almacenado
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
