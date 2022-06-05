package db;

import conexion.ConexionDb;
import POJO.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static utilidades.UtilidadesDb.*;
public class Actualizar {
    public static void actualizar(Usuario us,int id) {
        Connection connection = ConexionDb.conectar() ;
        boolean conValid = true;
        try{
            Statement declaracion =connection.createStatement();
            if(conValid == connection.isValid(2000)){
                declaracion.executeUpdate(String.format(QUERY_UPDATE,us.getNombreUsuario(),us.getApellidoPaterno(), us.getApellidoMaterno(), us.getEdadUsuario(), us.getSexoUsuario(), us.getTelefonoUsuario(), us.getEmailUsuario(),id));
                ConexionDb.cerrarConexion(connection,declaracion);
            }
            else {
                System.out.println(TEST_FAIL);
            }
             }catch (SQLException e){
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
    }
}
