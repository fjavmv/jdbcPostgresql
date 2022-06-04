package db;

import conexion.ConexionDb;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static pojo.PojoDb.*;
public class Actualizar {
    public static void actualizar(Usuario us){
        Connection connection = ConexionDb.conectar() ;
        int dat = 0;
        boolean conValid = true;
        try{
            if(conValid == connection.isValid(2000)){
                Statement declaracion = connection.createStatement();
                dat = declaracion.executeUpdate(String.format(QUERY_UPDATE, us.getNombreUsuario(),us.getApellidoPaterno(), us.getApellidoMaterno(), us.getEdadUsuario(), us.getSexoUsuario(), us.getTelefonoUsuario(), us.getEmailUsuario(),us.getIdUsuario()));
                ConexionDb.cerrarConexion(connection,declaracion);
            }
            else {
                System.out.println(TEST_FAIL);
            }
             }catch (SQLException e){
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        System.out.printf("\nLos datos se han actualizado para el id: %d con estado: %d", us.getIdUsuario(),dat);
    }
}
