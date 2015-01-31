package com.bridadan.box2dengine.map.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.bridadan.box2dengine.PhysicsStage;

public abstract class PhysicsMapObject extends MapObject{
	protected static final float defaultFixtureDefDensity = 1.0f;
	protected static final float defaultFixtureDefFriction = 0.2f;
	protected static final float defaultFixtureDefRestitution = 1.0f;
	
	protected BodyDef bodyDef;
	protected FixtureDef fixtureDef;
	protected Body body;
	protected TextureRegion textureRegion;
	
	protected PhysicsMapObject() {
		fixtureDef = new FixtureDef();
		fixtureDef.density = defaultFixtureDefDensity;
		fixtureDef.friction = defaultFixtureDefFriction;
		fixtureDef.restitution = defaultFixtureDefRestitution;
	}
	
	protected void createPhysics(World world, BodyDef bodyDef, Shape shape) {
		this.bodyDef = bodyDef;
		fixtureDef.shape = shape;
		addToWorld(world);
	}
	
	protected void createPhysics(World world, BodyDef bodyDef, FixtureDef fixtureDef) {
		this.bodyDef = bodyDef;
		this.fixtureDef = fixtureDef;
	    addToWorld(world);
	}
	
	protected void addToWorld(World world) {
		body = world.createBody(bodyDef);
		body.createFixture(fixtureDef);
	}
	
	public void draw(Batch batch, float parentAlpha) {
		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
		batch.draw(textureRegion,
			PhysicsStage.toScreenSize(body.getPosition().x) - PhysicsStage.toScreenSize(body.getLocalCenter().x),
			PhysicsStage.toScreenSize(body.getPosition().y) - PhysicsStage.toScreenSize(body.getLocalCenter().y),
			body.getLocalCenter().x,
			body.getLocalCenter().y,
			textureRegion.getRegionWidth(),
			textureRegion.getRegionHeight(),
			1.0f,
			1.0f,
			(float) Math.toDegrees(body.getAngle()));				
	}
	
	protected Body getBody() {
		return body;
	}
	
	protected void setTexture(Texture texture) {
		this.textureRegion = new TextureRegion(texture);
	}
	
	protected void setTextureRegion(TextureRegion textureRegion) {
		this.textureRegion = textureRegion;
	}
	
	protected TextureRegion getTextureRegion() {
		return textureRegion;
	}
}
