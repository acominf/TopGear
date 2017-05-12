import javax.swing.*;

/**
 * Created by Henry on 08/05/2017.
 */
public class Ventana extends JFrame{

    private Lienzo dibujo;
    public Ventana(int ancho, int alto)
    {
        this.setSize(ancho,alto);
        dibujo = new Lienzo();
        this.add(dibujo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
