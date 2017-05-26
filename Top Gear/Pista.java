import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pista extends World
{
    private int limite = 0, menergia = 8;
    private boolean ejecutando  = false;
    private Bache [] bache = new Bache[2];
    private Player player = new Player();
    private Otros [] otros = new Otros[3];
    private Etiqueta vidas = new Etiqueta("VIDAS: 3");
    private Etiqueta distancia = new Etiqueta("METROS: 0");
    private Etiqueta []menu = new Etiqueta[3];
    private Imagen energia = new Imagen("auto2.png");
    private Boton play = new Boton("icon.png");
    private Boton records = new Boton("record.png");
    private Boton ayuda = new Boton("ayuda.png");
    private Imagen senal = new Imagen("stop.png");
    private Boton atras = new Boton("exit.png");
    private GreenfootSound carrera = new GreenfootSound("Ace.mp3");
    
    public Pista()
    {    
        super(600, 400, 1); 
        objetos();
        menu();
    }
    public void act(){
        if(ejecutando){
            actualizaDatos();
            if(player.getMuerto()){
                reiniciaNivel();
                finJuego();
            }
        }
        revisaBotones();
    }
    
    public void objetos(){
        for(int i = 0; i < 2; i++)
            bache[i] = new Bache();
        for(int i = 0; i < 3; i++)
            otros[i] = new Otros();
        menu[0] = new Etiqueta("INICIAR");
        menu[1] = new Etiqueta("RECORDS");
        menu[2] = new Etiqueta("AYUDA");
    }
    
    public void menu(){
        setBackground("TopGear2.jpg");
        addObject(play,150,220);
        addObject(records,300,220);
        addObject(ayuda,450,220);
        addObject(menu[0],190,160);
        addObject(menu[1],340,160);
        addObject(menu[2],470,160);
        removeObject(atras);
    }
    
    public void cargaEscenario(){
        setBackground("pista.png");
        addObject(bache[0],Greenfoot.getRandomNumber(270)+100,-100);
        addObject(bache[1],Greenfoot.getRandomNumber(270)+100,180);
        addObject(player,215,330);
        addObject(senal,33,30);
        addObject(energia,550,100);
        addObject(vidas,500,280);
        addObject(distancia,500,330);
        Greenfoot.playSound("Ace.mp3");
        carrera.playLoop();
    }
    
    public void actualizaDatos(){
        distancia.reescribe("Metros: " + player.getMetros()/5);
        vidas.reescribe("Vidas: " + player.getVidas());
        if(menergia != player.getEnergia()){
            menergia = player.getEnergia();
            energia.setImage("Kirby"+menergia+".png");
        }
        if((player.getMetros()) % 2500 == 0){
            for(int i = 0; i < 3; i++)
                otros[i].setVelocidad(otros[i].getVelocidad()+1);
            bache[0].setVelocidad(bache[0].getVelocidad()+1);
            bache[1].setVelocidad(bache[1].getVelocidad()+1);
            Greenfoot.playSound("Ace.mp3");
            limite++;
            if(limite < 4)
                senal.setImage(limite+"stop.png");
        }
        if((player.getMetros()/5)>=2500)
            juegoGanado();
        if((player.getMetros()/5)>=500)
            addObject(otros[0],Greenfoot.getRandomNumber(90)+100,0);
        if((player.getMetros()/5)>=1000)
            addObject(otros[1],Greenfoot.getRandomNumber(90)+190,0);
        if((player.getMetros()/5)>=2000)
            addObject(otros[2],Greenfoot.getRandomNumber(90)+280,0);
    }
    
    public void revisaBotones(){
        if(play.getPresionado()){
           play.setPresionado(false);
           remueveMenu();
           addObject(atras,35,365);
           cargaEscenario();
           ejecutando=true;
        }
        else if(records.getPresionado()){
            records.setPresionado(false);
            remueveMenu();
            setBackground("record.png");
            addObject(atras,35,365);
        }
        else if(ayuda.getPresionado()){
            ayuda.setPresionado(false);
            remueveMenu();
            setBackground("TopGear2.jpg");
            addObject(atras,35,365);
        }
        if(atras.getPresionado()){
            atras.setPresionado(false);
            remueveEscenario();
            menu();
            ejecutando=false;
        }
    }
    
    public void remueveMenu(){
         removeObject(play);
        removeObject(records);
        removeObject(ayuda);
        for(int i=0; i<3; i++)
            removeObject(menu[i]);
    }
    
    public void remueveEscenario(){
        removeObject(bache[0]);
        removeObject(bache[1]);
        for(int i=0; i<3; i++)
            removeObject(otros[i]);
        removeObject(player);
        removeObject(energia);     
        removeObject(vidas);
        removeObject(distancia);
        removeObject(atras);
        removeObject(senal);
        carrera.stop();
    }
    
    public void finJuego(){
        remueveEscenario();
        setBackground("piedra.png");
        Greenfoot.delay(400);
        ejecutando=false;//por haber perdido
        menu();
    }
    
     public void juegoGanado(){
        remueveEscenario();
        setBackground("Kirby.png");
        Greenfoot.delay(600);
        ejecutando=false;
        menu();
    }
    
    public void reiniciaNivel(){
        player.restaurar();
        for(int i=0; i<3; i++)
            otros[i].setVelocidad(2);
        bache[0].setVelocidad(1);
        bache[1].setVelocidad(1);
        limite=0;
        senal.setImage("stop.png");
    }
}