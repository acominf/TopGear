package com.topgear.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import org.omg.CORBA.PUBLIC_MEMBER;

public class TopGearGame extends ApplicationAdapter{
    SpriteBatch batch;
    Texture img;
    private OrthographicCamera camera;
    private Carro auto;
    private Pista pista;

	@Override
	public void create () {
		batch = new SpriteBatch(); //agrupacion de sprites u objetos que se van a dibujar

		camera = new OrthographicCamera();
		camera.setToOrtho(false,1000,600); //y apunta hacia arriba
		camera.update();

		auto = new Carro(200,240);
		pista = new Pista(0,0);


	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {

		//limpiar el buffer del dibujo
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		auto.dibujar(batch);
		pista.dibujar2(batch);
		//dibujar mas objetos en el mundo
		batch.end(); //finalizar
	}

	
	@Override
	public void dispose () {
		batch.dispose();
		auto.dispose();
	}
}
