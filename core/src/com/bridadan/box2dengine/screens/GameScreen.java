package com.bridadan.box2dengine.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.bridadan.box2dengine.Box2dEngine;
import com.bridadan.box2dengine.PhysicsStage;

public class GameScreen implements Screen{
	private Game game;
	private PhysicsStage stage;
	
	public GameScreen(Box2dEngine game) {
		this.game = game;
		this.stage = new PhysicsStage();
	}

	@Override
	public void render(float delta) {
		//Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Update the stage
        stage.draw();
        stage.act(delta);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
