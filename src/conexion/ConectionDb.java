package conexion;

import modelo.Usuario;
import static POJO.PojoDb.*;
import java.sql.*;
import java.util.ArrayList;
public class ConectionDb {
    Connection connection = null;
    Statement declaracion = null;
    // id
    private int id;
    //Almacenar elementos de la db en un ArrayList
    private ArrayList<Usuario> usuario = new ArrayList<Usuario>();
    //Constructor de la clase que recibe como parametro el id
    public ConectionDb(int id) {
        this.id = id;
    }
    //Constructor vacio
    public ConectionDb() {
    }
    //metodo que realiza la conexión de manera generica
    public void conectarDb() {
        try {
            //Al método forName le pasamos el DRIVER para conectar a las DB
            /**
             * es solo devolver el objeto para el parámetro
             * que fue cargado por el cargador de clases.
             */
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
            if (valid) {
                System.out.println(valid ? TEST_OK : TEST_FAIL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
    }
    //Consulta de personas
    public ArrayList<Usuario> consultarUsuarios() {
        try {
            //Realizar la consulta a la db
            declaracion = connection.createStatement();
            /**
             * Un ResultSet, o conjunto de resultados, contiene los resultados
             * de una consulta SQL, por lo que es un conjunto de filas obtenidas
             * desde una base de datos, así como Metadatos sobre la consulta y los
             * tamaños de cada columna.
             */
            ResultSet rs = declaracion.executeQuery(QUERY_USUARIOS);
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
            //Cerramos conexión a la db
            rs.close();
            declaracion.close();
            connection.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }

        return usuario;
    }
    //Consultar por identificador
    public ArrayList<Usuario> consultarUsuariosId() {
        try {
            //Realizar la consulta a la db
            declaracion = connection.createStatement();

            ResultSet rs = declaracion.executeQuery(QUERY_ID + id + ";");
            /**
             * Para recuperar datos de una tabla utilizando una sentencia SELECT
             * sin marcadores de parámetros, puede utilizar el método Statement.executeQuery.
             */
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
            //Cerramos conexión a la db
            rs.close();
            declaracion.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        return usuario;
    }
    public void insertarElementos(String nombreUsuario, String apellidoPaterno, String apellidoMaterno,
                                  int edadUsuario, String sexoUsuario, String telefonoUsuario, String emailUsuario) {
        int dat = 0;
        try {
            declaracion = connection.createStatement();
            dat = declaracion.executeUpdate(String.format(QUERY_INSERT, nombreUsuario, apellidoPaterno, apellidoMaterno, edadUsuario, sexoUsuario, telefonoUsuario, emailUsuario));
            //Cerramos conexión a la db
            cerrarConexion();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        System.out.println("Registro correcto: " + dat);
    }
    public void cerrarConexion() throws SQLException {
        declaracion.close();
        connection.close();
    }

    public ResultSet actualizar(){
        return null;
    }





}
