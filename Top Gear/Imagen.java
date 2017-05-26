import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Imagen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Imagen extends Actor
{
    private int velocidad = 0;
    public Imagen(String nombre){
        this.velocidad = 0;
        setImage(nombre);
    }
    
    public Imagen(String nombre, int velocidad){
        this.velocidad = velocidad;
        setImage(nombre);
    }
    public void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }  
    public int getVelocidad(){
        return this.velocidad;
    }
    public void mover() {
        setLocation(getX(), getY()+velocidad);
        if(getY()>=399)//si se llega al final de pantalla
            setLocation(Greenfoot.getRandomNumber(260)+100,0);
    }
    public boolean choque(Class clase){
        Actor chocado = getOneIntersectingObject(clase);
        return chocado != null;
    }
}
