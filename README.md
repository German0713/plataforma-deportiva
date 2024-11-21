# Plataforma Deportiva

Este proyecto es una plataforma para gestionar usuarios y otros aspectos relacionados con el deporte, como el registro de actividades, resultados, y seguimiento de usuarios. El sistema permite registrar nuevos usuarios, actualizar sus datos, y gestionar otras funcionalidades.

## Tecnologías utilizadas

- **Java**: Lenguaje de programación principal.
- **JDBC**: Conexión con bases de datos.
- **MySQL** (o la base de datos que uses): Para almacenar la información.
- **Swing**: Para la interfaz gráfica de usuario (GUI).

## Requisitos previos

Antes de comenzar, asegúrate de tener instalados los siguientes programas:

- Java 8 o superior.
- Un servidor de base de datos como MySQL o cualquier otro compatible con JDBC.
- Un IDE de Java (Ej: IntelliJ IDEA, Eclipse).

## Instalación

1. **Clonar el repositorio**:
    ```bash
    git clone https://github.com/TuUsuario/plataforma-deportiva.git
    ```

2. **Configurar la base de datos**:
   - Crea una base de datos llamada `plataforma_deportiva` y ajusta los parámetros de conexión en el archivo `DatabaseConnection.java` (puedes modificar la URL, usuario y contraseña de la base de datos).

3. **Compilar y ejecutar el proyecto**:
   - Si usas un IDE como IntelliJ IDEA o Eclipse, solo abre el proyecto y ejecuta la clase principal.
   - Desde la terminal:
     ```bash
     javac -d bin src/com/plataformadeportiva/*.java
     java -cp bin com.plataformadeportiva.Main
     ```

## Funcionalidades

- **Registrar Usuario**: Permite registrar un nuevo usuario con nombre, correo electrónico y contraseña.
- **Actualizar Usuario**: Permite modificar los datos de un usuario registrado.
- **Eliminar Usuario**: Permite eliminar un usuario del sistema.
- **Consulta de Usuario**: Permite consultar la información de los usuarios registrados.

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

### Descripción de las carpetas y archivos:

- **`src/`**: Contiene todo el código fuente del proyecto.
  - **`auth/`**: Contiene utilidades relacionadas con la autenticación, como la clase `PasswordUtils` para encriptar las contraseñas.
  - **`database/`**: Contiene las clases relacionadas con la base de datos, como `DatabaseConnection` para la conexión y `InsertUser` para gestionar las operaciones CRUD en los usuarios.
  - **`gui/`**: Contiene las clases relacionadas con la interfaz gráfica de usuario (Swing), como `RegisterUserForm` para registrar nuevos usuarios.
  - **`Main.java`**: La clase principal que arranca el proyecto y realiza la ejecución del sistema.
  
- **`bin/`**: Aquí se almacenan los archivos compilados (`.class`).
  
- **`lib/`**: Si usas bibliotecas externas, las agregarías aquí. (Por ejemplo, controladores JDBC para MySQL).
  
- **`README.md`**: Este archivo de documentación con la descripción del proyecto, tecnologías, instalación, etc.

---
    

