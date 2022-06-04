package principal;

import conexion.ConectionDb;
import modelo.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

public class View {

    //Menu de opciones
    public void menuDeOpciones(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("**********************************************************");
        System.out.println("Selecciona la operación a realizar");
        System.out.println("Consultar elementos por ID opción---> 1: ");
        System.out.println("Consultar todos los elementos opción---> 2: ");
        System.out.println("Insertar elementos opción---> 3: ");
        System.out.println("Opcion 4 para salir");
        System.out.println("**********************************************************\n");
        int op = scanner.nextInt();
        switch (op){
            case 1:
                System.out.println("Ingresa el ID a consultar:  \n");
                int id = scanner.nextInt();
                ConectionDb db = new ConectionDb(id);
                db.conectarDb();
                ArrayList<Usuario> usuariosId = db.consultarUsuariosId();
                System.out.println(usuariosId.get(0).toString());
                menuDeOpciones();
                break;
            case 2:
                ConectionDb consulta = new ConectionDb();
                consulta.conectarDb();
                ArrayList<Usuario> usuarios = consulta.consultarUsuarios();
                for (Usuario usuario : usuarios) {
                    System.out.println(usuario.toString());
                    System.out.println(" ");
                }
                menuDeOpciones();
                break;
            case 3:
                guardarDatos(capturaDatos());
                break;
            case 4:

                break;
            case 5:

                break;
            default:
                System.out.println("Opcion invalida.....\n");
                System.out.println(" ");
                menuDeOpciones();
                break;
        }

    }

    private Usuario capturaDatos(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los datos a capturar:\n");
        System.out.println("Introduce nombre:");
        String nombreUsuario = scanner.next();
        System.out.println("Introduce apellido paterno:");
        String apellidoPaterno =scanner.next(); ;
        System.out.println("Introduce apellido materno:");
        String apellidoMaterno = scanner.next();
        System.out.println("Introduce edad:");
        int edadUsuario = scanner.nextInt();
        System.out.println("Introduce sexo (hombre o  mujer):");
        String sexoUsuario = scanner.next();
        System.out.println("Introduce tel:");
        String telefonoUsuario = scanner.next();
        System.out.println("Introduce tu correo:");
        String emailUsuario = scanner.next();
        Usuario us = new Usuario(nombreUsuario,apellidoPaterno,apellidoMaterno,edadUsuario,sexoUsuario,telefonoUsuario,emailUsuario);
        return us;
    }

    private void guardarDatos(Usuario us){
        ConectionDb insertar = new ConectionDb();
        insertar.conectarDb();
        insertar.insertarElementos(us.getNombreUsuario(),
                us.getApellidoPaterno(),
                us.getApellidoPaterno(),
                us.getEdadUsuario(),
                us.getSexoUsuario(),
                us.getTelefonoUsuario(),
                us.getEmailUsuario());
    }
}
