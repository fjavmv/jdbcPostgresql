package conexion;

import static utilidades.UtilidadesDb.*;
import java.sql.*;

public class ConexionDb {
    //metodo que realiza la conexión de manera generica
    public static Connection conectar(){
        Connection connection = null;
        /*
         *Al método forName le pasamos el DRIVER para conectar a las DB
         * es solo devolver el objeto para el parámetro
         * que fue cargado por el cargador de clases.
         */
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            System.out.println(ERROR_DRIVER + ex);
        }

        //Conexión a la db Postgresql
        try {
            //Pasamos datos para la conexión url, host, port, dbnombre, usuario y contraseña para conectar a la DB
            connection = DriverManager.getConnection(URL, USER, PASS);
            // Método para comprobación de conexión valida
            boolean valid = connection.isValid(5000);
            System.out.println(valid ? TEST_OK : TEST_FAIL);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        System.out.println(CONEXION_EXITOSA);
        return connection;
    }

    public static void cerrarConexion(Connection connection,Statement statement,ResultSet rs) throws SQLException {
        rs.close();
        statement.close();
        connection.close();
    }
    public static void cerrarConexion(Connection connection,Statement statement) throws SQLException {
        statement.close();
        connection.close();
    }
}
