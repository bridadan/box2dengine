package com.bridadan.box2dengine.map;

import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.bridadan.box2dengine.map.objects.CircleMapObject;

public class PhysicsMap extends Map {
	private World world;
	
	public PhysicsMap() {
		world = new World(new Vector2(0, -10), true);
        
		MapLayer physicsLayer = new MapLayer();
		physicsLayer.setName("Physics");
		physicsLayer.setOpacity(1f);
		physicsLayer.setVisible(true);
		
		CircleMapObject circle = new CircleMapObject(world, 20f, 11.25f, 1f);
		physicsLayer.getObjects().add(circle);
		
		getLayers().add(physicsLayer);
	}
	
	public World getWorld() {
		return world;
	}
}
