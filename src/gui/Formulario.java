package gui;

import POJO.Usuario;
import db.Consultar;
import db.Insertar;
import principal.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Formulario  extends JFrame{
    private JPanel panelBase;
    private JOptionPane jOptionPane;
    private JTextField txtFIdUser;
    private JTextField txtFNameUser;
    private JTextField txtFApaterno;
    private JTextField txtFAmaterno;
    private JTextField txtFEdad;
    private JTextField txtFSexo;
    private JButton btnRegistrar;
    private JTextField txtFEmail;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnConsultar;
    private JButton btnBporId;
    private JTextField txtFTel;
    private JTextPane txtPmostrar;
    int val;

    public static final int ANCHO = 850;
    private static  final int ALTO = 720;
    public Formulario(){
        super("Formulario DB");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelBase);
        this.pack();
        setSize(ANCHO,ALTO);
        setVisible(true);

        btnBporId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                val = Integer.parseInt(txtFIdUser.getText());
                ArrayList<Usuario> usuariosId = Consultar.consultarPorId(val);
                txtPmostrar.setText(String.valueOf(usuariosId.get(0).toString()));
            }
        });
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aqui va el código para que funcione mi botón
                Insertar.insertarElementos(obterDatosView());

                JOptionPane.showMessageDialog(panelBase,"Datos guardados","Información",JOptionPane.INFORMATION_MESSAGE);
                limpiar();

            }
        });
    }

    private Usuario obterDatosView(){
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(txtFNameUser.getText());
        usuario.setApellidoPaterno(txtFApaterno.getText());
        usuario.setApellidoMaterno(txtFAmaterno.getText());
        usuario.setEdadUsuario(Integer.parseInt(txtFEdad.getText()));
        usuario.setSexoUsuario(txtFSexo.getText());
        usuario.setTelefonoUsuario(txtFTel.getText());
        usuario.setEmailUsuario(txtFEmail.getText());
        return usuario;
    }

    private void limpiar(){
        txtFNameUser.setText("");
        txtFApaterno.setText("");
        txtFAmaterno.setText("");
        txtFEdad.setText("");
        txtFSexo.setText("");
        txtFTel.setText("");
        txtFEmail.setText("");
    }

}
