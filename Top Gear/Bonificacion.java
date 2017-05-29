import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bonificacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bonificacion extends Actor
{
    /**
     * Act - do whatever the Bonificacion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    public void Movi()
    {
        int y=getY();
        y=y+2;
        setLocation(getX(), y);
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
