package com.bridadan.box2dengine.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.bridadan.box2dengine.Box2dEngine;

public class Circle extends PhysicsActor {
	protected static BodyDef bodyDef;
	protected CircleShape circle;
	protected static FixtureDef fixtureDef;
	protected static Texture texture = Box2dEngine.assets.get("data/textures/ball.png", Texture.class);
	

	public Circle(float x, float y) {
        bodyDef = new BodyDef();  
        bodyDef.type = BodyType.DynamicBody;  
        bodyDef.position.set(x, y);  
        
        circle = new CircleShape();
        circle.setRadius(1f);  
        
        fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;  
        fixtureDef.density = 1.0f;  
        fixtureDef.friction = 0.0f;  
        fixtureDef.restitution = 1;
        
        setWidth(toWorldSize(2 * circle.getRadius()));
        setHeight(toWorldSize(2 * circle.getRadius()));
        setOriginX((getWidth() / 2f));
        setOriginY((getHeight() / 2f));
        System.out.println(circle.getRadius());
	}

	@Override
	public void addToWorld(World world) {
		// TODO Auto-generated method stub
		Body body = world.createBody(bodyDef);
		body.createFixture(fixtureDef);
		
		body.applyAngularImpulse(1f, true);
		setBody(body);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(texture,
				toWorldSize(getX()) - getOriginX(),
				toWorldSize(getY()) - getOriginY(),
				getOriginX(),
				getOriginY(),
				getWidth(),
				getHeight(),
				getScaleX(),
				getScaleY(),
				(float) Math.toDegrees(body.getAngle()),
				0,
				0,
				texture.getWidth(),
				texture.getHeight(),
				false,
				false);
				
				
	}
	
}
