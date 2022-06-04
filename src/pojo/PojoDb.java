package pojo;
public class PojoDb {
    //Datos de para conectar a la Db//////////////////////////
    public static final String DRIVER = "org.postgresql.Driver";
    private static final String HOST = "localhost";
    private static final String PORT = "5432";
    private static final String DB_NAME = "biblioteca";
    public static String URL = String.format("jdbc:postgresql://%s:%s/%s",HOST,PORT,DB_NAME);
    public static final String USER = "postgres";
    public static final String PASS = "A9BXZWC173";
    /////////////////////////////////////////////////////////////
    public static final String TEST_OK = "TEST OK";
    public static final String TEST_FAIL = "TEST FAIL";
    public static final String ERROR_DRIVER = "Error al registrar el driver de PostgreSQL: ";
    //Mensajes conexión exitosa
    public static final String CONEXION_EXITOSA = "La conexión a las DB ha sido exitosa....";
    //Consulta
    public static final String QUERY_USUARIOS = "SELECT id_usuario, nombre_usuario, apellido_paterno, apellido_materno, edad_usuario, sexo_usuario, telefono_usuario, email_usuario FROM usuarios ORDER BY id_usuario ASC;";
    public static final String QUERY_ID = "SELECT id_usuario, nombre_usuario, apellido_paterno, apellido_materno, edad_usuario, sexo_usuario, telefono_usuario, email_usuario FROM usuarios WHERE id_usuario = %s ;";
    public static final String QUERY_INSERT= "INSERT INTO usuarios (nombre_usuario, apellido_paterno, apellido_materno, edad_usuario, sexo_usuario, telefono_usuario, email_usuario) VALUES ('%s','%s','%s',%d,'%s','%s','%s');";
    //-- Para eliminar todo
   // public  static  final String QUERY_ELIMINAR_TODO = "DELETE FROM usuarios";
    //-- Para borrar un conjunto de registros
    public  static  final String QUERY_ELIMINAR = "DELETE FROM usuarios WHERE id_usuario = %d";
    public static String QUERY_UPDATE = "UPDATE usuarios SET nombre_usuario = %s, apellido_paterno = %s, apellido_materno = %s, edad_usuario = %d, sexo_usuario = %s, telefono_usuario = %s, email_usuario = %s WHERE id_usuario = %d";

}
