import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.ImageIcon;

/**
 * Created by Henry on 08/05/2017.
 */
public class Lienzo extends JPanel{

    //ImageIcon imagen;
    //String nombre;

    /*public Lienzo (String nombre)
    {
        this.nombre=nombre;
    }*/

    @Override
    public void paintComponent(Graphics g)
    {
        ImageIcon imagen=new ImageIcon("C:\\Users\\Henry\\Pictures\\auto1.png");
        ImageIcon logo=new ImageIcon("C:\\Users\\Henry\\Pictures\\logo.png");

        g.drawImage(imagen.getImage(),30,350,350,100,null);
        g.drawImage(logo.getImage(),30,5,900,300,null);
        setOpaque(false);
        super.paintComponent(g);
    }


}
