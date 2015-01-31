package com.bridadan.box2dengine.map.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.utils.Array;

/** {@link AssetLoader} for {@link BitmapFont} instances. Loads the font description file (.fnt) asynchronously, loads the
 * {@link Texture} containing the glyphs as a dependency. The {@link BitmapFontParameter} allows you to set things like texture
 * filters or whether to flip the glyphs vertically.
 * @author mzechner */
public class JSONMapLoader extends AsynchronousAssetLoader<Map, JSONMapLoader.JSONMapLoaderParameters> {

	public JSONMapLoader(FileHandleResolver resolver) {
		super(resolver);
		// TODO Auto-generated constructor stub
	}

	static public class JSONMapLoaderParameters extends AssetLoaderParameters<Map> {
	}

	@Override
	public void loadAsync(AssetManager manager, String fileName,
			FileHandle file, JSONMapLoaderParameters parameter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map loadSync(AssetManager manager, String fileName, FileHandle file,
			JSONMapLoaderParameters parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array<AssetDescriptor> getDependencies(String fileName,
			FileHandle file, JSONMapLoaderParameters parameter) {
		// TODO Auto-generated method stub
		return null;
	}


}