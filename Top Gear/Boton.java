import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boton extends Actor
{
    boolean presionado = false;
    public Boton(String imagen){
        setImage(imagen);
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
           presionado=true;
        else if(!Greenfoot.mouseClicked(this))
           presionado=false;
    }
    
     public void setPresionado(boolean presionado){
        this.presionado=presionado;
    }
    
    public boolean getPresionado(){
        return presionado;
    }
}
