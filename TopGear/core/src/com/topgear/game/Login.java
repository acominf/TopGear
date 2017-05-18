package com.topgear.game;

import javax.swing.*;

/**
 * Created by Henry on 16/05/2017.
 */
public class Login extends JFrame {

    //Objetos al ingreso
    private JLabel usuario;
    private JLabel clave;
    private JLabel imagen;
    private JTextField txtusuario;
    private JPasswordField txtclave;
    private JButton aceptar;
    private JButton cancelar;

    //constructor
    public Login() {
        //propiedades del formulario
        setTitle("INGRESO AL SISTEMA");
        setResizable(false);
        setSize(390, 180);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creamos los iconos

        //ImageIcon icoIngreso = new ImageIcon(getClass().getResource("C:\\Users\\Henry\\IdeaProjects\\TopGear\\Inicio.png"));

        //crear objetos del ingreso

        usuario = new JLabel("Usuario: ");
        txtusuario = new JTextField(10);
        clave = new JLabel("Clave: ");
        txtclave = new JPasswordField(15);
        aceptar = new JButton("Aceptar");
        cancelar = new JButton("Cancelar");


        //Incluimos objetos al formulario

        add(usuario);
        add(txtusuario);
        add(clave);
        add(txtclave);
        add(aceptar);
        add(cancelar);
        //add(imagen);

        //Ubicamos los objetos en el formulario

        usuario.reshape(20, 20, 100, 20);
        txtusuario.reshape(120, 20, 100, 20);
        //imagen.reshape(250,20, 200, 250);

        clave.reshape(20, 45, 100, 20);
        txtclave.reshape(120, 45, 100, 20);

        aceptar.reshape(20, 75, 90, 50);
        cancelar.reshape(130, 75, 90, 50);
    }
}
