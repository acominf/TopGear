import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Carro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carro extends Imagen
{
    private static int jugadorX;
    
     public Carro(String nombre,int velocidad){
        super(nombre,velocidad);
    }
    
    public void setjugadorX(int coordx) 
    {
        jugadorX = coordx;
    }    
    
    public int getjugadorX(){
        return jugadorX;
    }
}
