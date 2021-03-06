package db;

import conexion.ConexionDb;
import POJO.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static utilidades.UtilidadesDb.*;

public class Insertar {
    public static void insertarElementos(Usuario us) {
        //Almacena un valo de retorno del método executeUpdate()
        int dat = 0;
        Connection connection = ConexionDb.conectar();
        boolean conValida = true;
        try {
            //Verifica si al conexión es valida
            if(conValida == connection.isValid(1000)){
                Statement declaracion = connection.createStatement();
                dat = declaracion.executeUpdate(String.format(QUERY_INSERT,us.getNombreUsuario(),us.getApellidoPaterno(), us.getApellidoMaterno(), us.getEdadUsuario(), us.getSexoUsuario(), us.getTelefonoUsuario(), us.getEmailUsuario()));
                //Cerramos conexión a la db
                ConexionDb.cerrarConexion(connection,declaracion);
            }
            else {
                System.out.println(TEST_FAIL);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        System.out.println("Registro correcto: " + dat);
    }
}
