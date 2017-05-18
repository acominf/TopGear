package com.topgear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Henry on 16/05/2017.
 */
public class Pista extends TopGearGame{
    private Sprite sprite;
    public int x,y;

    public Pista(int x, int y){
        this.x = x;
        this.y = y;
        //cargar la imagen
        sprite = new Sprite(new Texture(Gdx.files.internal("pista2.png")),450,200);
    }

    public void dibujar2(final SpriteBatch batch){
        batch.draw(sprite, x, y);
    }

    }
