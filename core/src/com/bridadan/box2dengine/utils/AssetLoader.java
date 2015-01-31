package com.bridadan.box2dengine.utils;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {
	static String pathPrefix = "";
	AssetManager assets;
	
	public AssetLoader() {
		this.assets = new AssetManager();
		
		/*if (Gdx.app.getType() == ApplicationType.Desktop) {
			pathPrefix = "./bin/";
		}*/
	}
	
	public void load(boolean async) {
		/*FileHandle dir;
		
		// TODO This will probably need to be fixed for distribution
		
		dir = Gdx.files.internal(getPath("data/textures/"));
		FileHandle[] files = dir.list();
		
		for(FileHandle file: files) {
		   // do something interesting here
			assets.load(file.path(), Texture.class);
		}*/
		
		assets.load("data/textures/ball.png", Texture.class);
		
		if (!async) {
			assets.finishLoading();
		}
	}
	
	public <T> T get(String fileName, Class<T> type) {
		return assets.get(getPath(fileName));
	}
	
	public void unload() {
		for (String name: assets.getAssetNames()) {
			assets.unload(name);
		}
	}
	
	private String getPath(String path) {
		return pathPrefix + path;
	}
}
