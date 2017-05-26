import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Otros here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Otros extends Carro
{
    private int direccion = 0;
    
    public Otros() {
        super("auto.png",2);
        setRotation(180);
    }
    public void act() 
    {
        mover();
        checaDesviar();
    }    
    
    public void checaDesviar(){
        if(choque(Player.class)){
           if (getX() <= getjugadorX())
               direccion = 2;
           else if (getX() > getjugadorX())
               direccion = 1;
           if (direccion == 1)
               setLocation(getX()+getVelocidad()*2, getY());
           if (direccion == 2)
               setLocation(getX()-getVelocidad()*2, getY());
        }
        else
            direccion = 0;
        if(choque(Otros.class)&getX()>30 | getX()>390 | getX()<70){
            getWorld().addObject(new Explosion(),getX(),getY());
            setLocation(Greenfoot.getRandomNumber(260)+100,0);
        }  
    }
}
