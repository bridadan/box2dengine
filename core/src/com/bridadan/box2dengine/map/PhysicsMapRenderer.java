package com.bridadan.box2dengine.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

public class PhysicsMapRenderer implements MapRenderer {
	protected Batch batch;
	protected Rectangle viewBounds;
	protected OrthographicCamera camera;
	protected Box2DDebugRenderer debugRenderer;
	protected PhysicsMap map;

    public PhysicsMapRenderer(PhysicsMap map, Batch batch) {
    	viewBounds = new Rectangle();
    	debugRenderer = new Box2DDebugRenderer();
    	this.map = map;
    	this.batch = batch;
    }
    
    public void setMap(PhysicsMap map) {
    	this.map = map;
    }
    
	@Override
	public void setView(OrthographicCamera camera) {
		this.camera = camera;
		//batch.setProjectionMatrix(camera.combined);
		float width = camera.viewportWidth * camera.zoom;
		float height = camera.viewportHeight * camera.zoom;
		viewBounds.set(camera.position.x - width / 2, camera.position.y - height / 2, width, height);
	}

	@Override
	public void setView(Matrix4 projectionMatrix, float viewboundsX,
			float viewboundsY, float viewboundsWidth, float viewboundsHeight) {
		//batch.setProjectionMatrix(projectionMatrix);
		viewBounds.set(viewboundsX, viewboundsY, viewboundsWidth, viewboundsHeight);
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		for (MapLayer layer : map.getLayers()) {
			for (MapObject object : layer.getObjects()) {
				object.
			}
		}
	}

	@Override
	public void render(int[] layers) {
		// TODO Auto-generated method stub
		
	}
	
	public void renderDebug() {
		debugRenderer.render(map.getWorld(), camera.combined);
	}

}
