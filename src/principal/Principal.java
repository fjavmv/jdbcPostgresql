package principal;
import modelo.Usuario;

import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        View view = new View();
        view.menuDeOpciones();
        Usuario us = new Usuario();
    }
}
