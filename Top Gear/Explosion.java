import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explocion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Imagen
{
    private static GreenfootImage []images;
    private int zoom = 0, contador = 0;
    
    public Explosion(){
        super ("gifs.gif");
        images=new GreenfootImage[10];
        for(int i=0; i<10; i++){
            images[i]=new GreenfootImage("estrellas.png");
            images[i].scale(75+(i*15),75+(i*15));
        }
    }
    public void act() 
    {
        setImage(images[zoom]);
        if(zoom>=9)
            getWorld().removeObject(this);
        contador++;
        if(contador>3){
           zoom++;
           contador=0;
        }
    }    
}
