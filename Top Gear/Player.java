import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Carro
{
    private int distancia = 0, energia = 8, vida = 3, nitroImg=0, contadorTurbulencia = 0;
    private boolean chocado = false, muerto = false, turbo = false;
    
    public Player() {
        super("auto.png",0);
    }
    
    public void setMetros(int distancia){
        this.distancia=distancia;
    }
    
    public void setVidas(int vida){
        this.vida=vida;
    }
    
    public void setEnergia(int energia){
        this.energia=energia;
    }
    
    public int getMetros(){
        return distancia;
    }
    
    public int getVidas(){
        return vida;
    }
    
    public int getEnergia(){
        return energia;
    }
    
    public boolean getMuerto(){
        return muerto;
    }
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("UP"))
           mover("arriba");
        else if(Greenfoot.isKeyDown("DOWN"))
           mover("abajo");        
        else if(Greenfoot.isKeyDown("LEFT"))
           mover("izquierda");
        else if(Greenfoot.isKeyDown("RIGHT"))
           mover("derecha");
        if(Greenfoot.isKeyDown("enter")&(distancia/5)>1000)
           turbo=true;
        if(Greenfoot.isKeyDown("space") | turbo==false){
           turbo=false;
           setImage("auto.png");
        }
        if(choque(Bache.class) & chocado==false | choque(Otros.class) & chocado==false)
            chocado = true;
        if(turbo==true)
            turboImg();
        turbulencia();
        distancia++;       
        setjugadorX(getX());
    }    
    
    public void mover(String direccion) {
        int gas;
        if(turbo)
            gas = 6;
        else
            gas = 2;
        if(direccion == "arriba"){
            setLocation(getX(), getY() - gas);
            distancia++;
        }
        else if(direccion == "abajo"){
            setLocation(getX(), getY() + gas);
            distancia--;
        }
        else if(direccion == "izquierda" & getX() > 90)
            setLocation(getX() - gas, getY());
        else if(direccion == "derecha" & getX() < 370)
            setLocation(getX() + gas, getY());
    }
    
    public void turbulencia(){
        if(chocado==true){
            if(contadorTurbulencia==5)
                if (energia >= 1)
                    energia--;
            contadorTurbulencia+=1;
            if(contadorTurbulencia<=20)
               setRotation(getRotation()-1);
            else
               setRotation(getRotation()+1);
            if(contadorTurbulencia==2){
                if(choque(Bache.class))
                    Greenfoot.playSound("Ace.mp3");
               Greenfoot.playSound("Ace.mp3");
            }
        }
        if(contadorTurbulencia >= 60){
            contadorTurbulencia = 0;
            chocado=false;
            setRotation(0);
            if(energia == 0){
                if (vida >= 2)
                   energia = 8;
                vida --;
            }
            if(vida == 0)
                muerto = true;
        }
    }
    
    public void turboImg(){
        if(nitroImg<5){
            nitroImg++;
            setImage("auto.png");
        }
        else if(nitroImg<10){
            nitroImg++;
            setImage("auto.png");
        }
        else{
            nitroImg++;
            setImage("auto.png");
            if(nitroImg==15)
               nitroImg=0;
        }
    }
    
     public void restaurar(){
         contadorTurbulencia = 0;
         distancia = 0;
         energia = 8;
         vida = 3;
         turbo = false;//estado del turbo
         chocado = false;
         muerto = false;
    }
}
