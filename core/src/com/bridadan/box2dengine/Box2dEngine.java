package com.bridadan.box2dengine;

import com.badlogic.gdx.Game;
import com.bridadan.box2dengine.screens.GameScreen;
import com.bridadan.box2dengine.utils.AssetLoader;

public class Box2dEngine extends Game {
	public static AssetLoader assets;
	@Override
	public void create() {
		// TODO Auto-generated method stub
		assets = new AssetLoader();
		assets.load(false);
		setScreen(new GameScreen(this));
	}
	
	@Override
	public void dispose() {
		assets.unload();
	}
}