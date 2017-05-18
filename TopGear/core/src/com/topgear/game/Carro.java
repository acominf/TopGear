package com.topgear.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

import java.awt.*;

/**
 * Created by Henry on 16/05/2017.
 */
public class Carro extends TopGearGame implements ApplicationListener{

    public int x,y;
    private TextureRegion [] regionsMovimiento;
    private Animation animation;
    private float tiempo;
    private Texture imagen;
    private TextureRegion frameActual;
    private Sprite sprite;

    public Carro(int x, int y){
        this.x = x;
        this.y = y;
        //cargar la imagen
        imagen = new Texture(Gdx.files.internal("secuencia2.png"));
        sprite = new Sprite(new Texture(Gdx.files.internal("pista2.png")),600,1000);
        TextureRegion [][] tmp = TextureRegion.split(imagen,imagen.getWidth()/4,imagen.getHeight());

        regionsMovimiento = new TextureRegion[4];
        for(int i=0; i<4;i++) regionsMovimiento[i] = tmp [0][i];
        animation = new Animation(1/10f,regionsMovimiento);
        tiempo = 0f;
    }

    public void dibujar(final SpriteBatch batch){
        tiempo += Gdx.graphics.getDeltaTime();//el tiempo que pasó desde el ultimo frame
        frameActual = (TextureRegion) animation.getKeyFrame(tiempo,true);
        batch.draw((TextureRegion) frameActual,x,y);

        // mover en el eje x
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                x+= 10;
        }

       if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                x-=10;
        }

        //mover en el eje y
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            y+= 10;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            y-=10;
        }

        if (x<=0) {
            x = 0;
        }
        if (x >= imagen.getWidth()+325){
            x=imagen.getWidth()+325;
        }

        if (y<=0){
            y=0;
        }
        if (y >= imagen.getHeight()+225){
            y=imagen.getHeight()+225;
        }


    }

    public void setX(){
        this.x = x;
    }
    public void setY(){
        this.y = y;
    }

    public int getX(int x){
        return x;
    }
    public int getY(int y){
        return y;
    }


    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
