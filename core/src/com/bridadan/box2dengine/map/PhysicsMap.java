package com.bridadan.box2dengine.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.bridadan.box2dengine.Box2dEngine;
import com.bridadan.box2dengine.actors.MapActor;
import com.bridadan.box2dengine.map.objects.BaseMapObject;
import com.bridadan.box2dengine.map.objects.ChainMapObject;
import com.bridadan.box2dengine.map.objects.CircleMapObject;
import com.bridadan.box2dengine.map.objects.PhysicsMapObject;
import com.bridadan.box2dengine.map.objects.PolygonMapObject;
import com.bridadan.box2dengine.map.objects.RectangleMapObject;

public class PhysicsMap extends Map {
	private World world;
	
	public PhysicsMap() {
		world = new World(new Vector2(0, -10), true);
        
		MapLayer physicsLayer = new MapLayer();
		physicsLayer.setName("Physics");
		physicsLayer.setOpacity(1f);
		physicsLayer.setVisible(true);
		
		// Circle
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(20f, 11.25f);
		
		CircleShape circleShape = new CircleShape();
		circleShape.setRadius(1.0f);
		
		PhysicsMapObject circle = new PhysicsMapObject();
		circle.setTextureRegion(new TextureRegion(Box2dEngine.assets.get("data/textures/ball.png", Texture.class)));
		circle.createPhysics(world, bodyDef, circleShape);
		physicsLayer.getObjects().add(circle);
		
		// Chain
		bodyDef.type = BodyType.StaticBody;
		bodyDef.position.set(19f, 1f);
		
		float[] rampVerts = {0, 4, 1, 1.5f, 2, 0.5f, 3, 0};
		ChainShape chainShape = new ChainShape();
		chainShape.createChain(rampVerts);;
		
		PhysicsMapObject ramp = new PhysicsMapObject();
		ramp.createPhysics(world, bodyDef, chainShape);
		physicsLayer.getObjects().add(ramp);
		
		// Rectangle
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(10f, 11.25f);
		
		PolygonShape boxShape = new PolygonShape();
		boxShape.setAsBox(1f, 0.5f);
		
		PhysicsMapObject box = new PhysicsMapObject();
		box.createPhysics(world, bodyDef, boxShape);
		physicsLayer.getObjects().add(box);
		box.getBody().applyAngularImpulse(-5f, true);
		
		// Polygon
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(30f, 11.25f);
		
		float[] trapezoidVerts = {-3, -1, -1, 1, 1, 1, 3, -1};
		PolygonShape trapezoid = new PolygonShape();
		trapezoid.set(trapezoidVerts);
		
		PhysicsMapObject polygon = new PhysicsMapObject();
		polygon.createPhysics(world, bodyDef, trapezoid);
		physicsLayer.getObjects().add(polygon);
		polygon.getBody().applyAngularImpulse(5f, true);
		
		// Ground
		bodyDef.type = BodyType.StaticBody;
		bodyDef.position.set(20f, 0.5f);
		
		boxShape.setAsBox(36f, 0.5f);
		
		PhysicsMapObject ground = new PhysicsMapObject();
		ground.createPhysics(world, bodyDef, boxShape);
		physicsLayer.getObjects().add(box);
		
		getLayers().add(physicsLayer);
	}
	
	public World getWorld() {
		return world;
	}
	
	public void addActors(Stage stage) {
		MapActor actor;
		for (MapLayer layer : getLayers()) {
			Group group = new Group();
			for (MapObject object : layer.getObjects()) {
				actor = new MapActor((BaseMapObject) object);
				group.addActor(actor);
				//object.
			}
			stage.addActor(group);
		}
		
		
	}
}
