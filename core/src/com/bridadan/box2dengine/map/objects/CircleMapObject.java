package com.bridadan.box2dengine.map.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.bridadan.box2dengine.Box2dEngine;

public class CircleMapObject extends PhysicsMapObject {
	
	public CircleMapObject(World world, BodyType bodyType, float x, float y, float radius) {
		super();
		
		setTextureRegion(new TextureRegion(Box2dEngine.assets.get("data/textures/ball.png", Texture.class)));
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = bodyType;  
        bodyDef.position.set(x, y);
        
        CircleShape shape = new CircleShape();
        shape.setRadius(radius);
        
        createPhysics(world, bodyDef, shape);
	}
}
