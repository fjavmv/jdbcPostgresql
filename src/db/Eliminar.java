package db;

import conexion.ConexionDb;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static pojo.PojoDb.*;

public class Eliminar {
    public static void eliminar(int id){
        Connection connection = ConexionDb.conectar();
        boolean conValida = true;
        try{
            if(conValida == connection.isValid(2000)){
                Statement declaracion = connection.createStatement();
                declaracion.executeUpdate(String.format(QUERY_ELIMINAR,id));
            }else {
                System.out.println(TEST_FAIL);
            }

        }catch (SQLException e){
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }

    }
}
