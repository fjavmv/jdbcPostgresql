package db;

import conexion.ConexionDb;
import POJO.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static utilidades.UtilidadesDb.*;

public class Consultar {
    //Esto es una clase interna
    private static class ObtenerDatos{
        private static ArrayList<Usuario> obtener(ResultSet rs){
            ArrayList<Usuario> usuario = new ArrayList<>();
            try{
                while (rs.next()) {
                    int idUsuario = rs.getInt("id_usuario");
                    String nombreUsuario = rs.getString("nombre_usuario");
                    String apellidoPaterno = rs.getString("apellido_paterno");
                    String apellidoMaterno = rs.getString("apellido_materno");
                    int edadUsuario = rs.getInt("edad_usuario");
                    String sexoUsuario = rs.getString("sexo_usuario");
                    String telefonoUsuario = rs.getString("telefono_usuario");
                    String emailUsuario = rs.getString("email_usuario");
                    //Llenamos la lista con los elementos del array list
                    usuario.add(new Usuario(idUsuario, nombreUsuario, apellidoPaterno, apellidoMaterno, edadUsuario, sexoUsuario, telefonoUsuario, emailUsuario));
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            return usuario;
        }
    }

    //Consultar todos los usuarios
    public static ArrayList<Usuario> consultar(){
        Connection connection = ConexionDb.conectar();
        ArrayList<Usuario> usuario = new ArrayList<>();
        ResultSet rs;
        boolean conValida = true;
        try {
            if(conValida == connection.isValid(1000)){
                //Realizar la consulta a la db
                Statement declaracion = connection.createStatement();
                rs = declaracion.executeQuery(QUERY_USUARIOS);
                //Pasamos el contenido del ResultSet al método obtener
                usuario = ObtenerDatos.obtener(rs);
                //Cerramos conexión a la db
                ConexionDb.cerrarConexion(connection,declaracion,rs);
            }else {
                System.out.println(TEST_FAIL);
            }
        } catch (SQLException e) {
        System.err.println(e.getClass().getName() + ":" + e.getMessage());
        System.exit(0);
        }
        return usuario;
    }

    //Consulta usuarios por ID
    public static  ArrayList<Usuario> consultarPorId(int id){
        Connection connection = ConexionDb.conectar();
        ArrayList<Usuario> usuario = new ArrayList<>();
        boolean conValida = true;
        try {
            if(conValida == connection.isValid(2000)){
                //Realizar la consulta a la db
                Statement declaracion = connection.createStatement();
                ResultSet rs = declaracion.executeQuery(String.format(QUERY_ID, id));
                //Pasamos el contenido del ResultSet al método obtener
                usuario = ObtenerDatos.obtener(rs);
                //Cerramos conexión a la db
                ConexionDb.cerrarConexion(connection,declaracion,rs);
            }else {
                System.out.println(TEST_FAIL);
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        return usuario;
    }
}




