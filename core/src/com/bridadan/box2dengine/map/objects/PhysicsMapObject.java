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

public class PhysicsMapObject extends BaseMapObject {
	protected static final float defaultFixtureDefDensity = 1.0f;
	protected static final float defaultFixtureDefFriction = 0.2f;
	protected static final float defaultFixtureDefRestitution = 0.4f;
	protected static final float defaultAngularDamping = 1.0f;
	
	protected BodyDef bodyDef;
	protected FixtureDef fixtureDef;
	protected Body body;
	protected TextureRegion textureRegion;
	
	public TextureRegion getTextureRegion() {
		return textureRegion;
	}

	public void setTextureRegion(TextureRegion textureRegion) {
		this.textureRegion = textureRegion;
	}

	public PhysicsMapObject() {
		fixtureDef = new FixtureDef();
		fixtureDef.density = defaultFixtureDefDensity;
		fixtureDef.friction = defaultFixtureDefFriction;
		fixtureDef.restitution = defaultFixtureDefRestitution;
	}
	
	public void createPhysics(World world, BodyDef bodyDef, Shape shape) {
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
		body.setAngularDamping(defaultAngularDamping);
		body.createFixture(fixtureDef);
	}
	
	public Body getBody() {
		return body;
	}
	
	@Override
	public float getAngle() {
		return body.getAngle();
	}
	
	@Override
	public void setAngle(float angle) {
		body.setTransform(body.getPosition().x, body.getPosition().y, angle);
	}

	@Override
	public void setX(float x) {
		body.setTransform(x, body.getPosition().y, body.getAngle());
		this.x = x;
	}

	@Override
	public void setY(float y) {
		body.setTransform(body.getPosition().x, y, body.getAngle());
	}

	@Override
	public void setOriginX(float originX) {
		body.getLocalCenter().set(originX, body.getLocalCenter().y);
	}

	@Override
	public void setOriginY(float originY) {
		body.getLocalCenter().set(body.getLocalCenter().y, originY);
	}

	@Override
	public float getX() {
		return body.getPosition().x;
	}
	
	@Override
	public float getY() {
		return body.getPosition().y;
	}
	
	@Override
	public float getOriginX() {
		return body.getLocalCenter().x;
	}
	
	@Override
	public float getOriginY() {
		return body.getLocalCenter().y;
	}
}
