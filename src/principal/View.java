package principal;

import db.Actualizar;
import db.Consultar;
import db.Eliminar;
import db.Insertar;
import POJO.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

public class View {

    //Menu de opciones
    public static void menuDeOpciones() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**********************************************************");
        System.out.println("Selecciona la operación a realizar");
        System.out.println("Consultar elementos por ID opción---> 1: ");
        System.out.println("Consultar todos los elementos opción---> 2: ");
        System.out.println("Registar elementos opción---> 3: ");
        System.out.println("Actualizar elementos opción---> 4: ");
        System.out.println("Eliminar elemento opción---> 5: ");
        System.out.println("Opcion -----> 6 para salir");
        System.out.println("**********************************************************\n");
        int op = scanner.nextInt();
        Usuario user;
        switch (op) {
            case 1:{
                System.out.println("Ingresa el ID a consultar:  \n");
                user = new Usuario(scanner.nextInt());
                ArrayList<Usuario> usuariosId = Consultar.consultarPorId(user.getIdUsuario());
                System.out.println(usuariosId.get(0).toString());
                System.out.println("Consulta exitosa...........");
                menuDeOpciones();
            }
            case 2: {
                ArrayList<Usuario> usuarios = Consultar.consultar();
                for (Usuario usuario : usuarios) {
                    System.out.println(usuario.toString());
                    System.out.println(" ");
                }
                System.out.println("Consulta exitosa...........");
                menuDeOpciones();
            }
            case 3: {
                System.out.println("Ingresa los datos a registrar:  \n");
                Insertar.insertarElementos(DatosView.capturaDatos());
                menuDeOpciones();
            }
            case 4: {
                System.out.println("Ingresa el ID a actualizar:  \n");
                int id = scanner.nextInt();
                Actualizar.actualizar(DatosView.capturaDatos(),id);
                System.out.println("Actualización finalizada................");
                menuDeOpciones();
            }
            case 5: {
                System.out.println("Ingresa el ID a eliminar:  \n");
                user = new Usuario(scanner.nextInt());
                Eliminar.eliminar(user.getIdUsuario());
                System.out.println("Se ha eliminado el registro con id: "+user.getIdUsuario());
                menuDeOpciones();
            }
            case 6: {
                System.exit(0);
                System.out.println("Programa finalizado..................");
            }
            default: {
                System.out.println("Opcion invalida.....\n");
                System.out.println(" ");
                menuDeOpciones();
            }
        }

    }

    //Esto es una innerClass o clase interna
    public static class DatosView{
        private static Usuario capturaDatos(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce los datos a registrar o actualizar:\n");
            System.out.println("Introduce el nombre de usuario:");
            String nombreUsuario = scanner.nextLine();
            System.out.println("Introduce apellido paterno:");
            String apellidoPaterno =scanner.next();
            System.out.println("Introduce apellido materno:");
            String apellidoMaterno = scanner.next();
            System.out.println("Introduce edad:");
            int edadUsuario = scanner.nextInt();
            System.out.println("Introduce sexo (hombre o  mujer):");
            String sexoUsuario = scanner.next();
            System.out.println("Introduce teléfono:");
            String telefonoUsuario = scanner.next();
            System.out.println("Introduce tu correo:");
            String emailUsuario = scanner.next();
            return new Usuario(nombreUsuario,apellidoPaterno,apellidoMaterno,edadUsuario,sexoUsuario,telefonoUsuario,emailUsuario);
        }
    }
}

