package com.bridadan.box2dengine.map.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.bridadan.box2dengine.Box2dEngine;

public class RectangleMapObject extends PhysicsMapObject {
	
	public RectangleMapObject(World world, BodyType bodyType, float x, float y, float width, float height) {
		super();
		
		setDrawable(false);
		//setTextureRegion(new TextureRegion(Box2dEngine.assets.get("data/textures/ball.png", Texture.class)));
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = bodyType;  
        bodyDef.position.set(x, y);
        
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width, height);
        
        createPhysics(world, bodyDef, shape);
	}
}
