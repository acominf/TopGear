import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Etiqueta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Etiqueta extends Actor
{
    private GreenfootImage etiqueta;
    
    public Etiqueta(String nom){
        etiqueta=new GreenfootImage(100,20);
        etiqueta.drawString(nom,10,10);
        etiqueta.scale(200,50);
        setImage(etiqueta);
    }
    public void reescribe(String dato) 
    {
        etiqueta=new GreenfootImage(100,20);
        etiqueta.drawString(dato,10,10);
        etiqueta.scale(200,50);
        setImage(etiqueta);
    }    
}
