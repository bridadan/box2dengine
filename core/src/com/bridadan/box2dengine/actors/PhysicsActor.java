package com.bridadan.box2dengine.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.bridadan.box2dengine.PhysicsStage;

public abstract class PhysicsActor extends Actor {
	protected Body body;
	
    public abstract void addToWorld(World world);
    
    protected float toWorldSize(float n) {
    	return n * PhysicsStage.WORLD_TO_SCREEN;
    }
    
    protected void setBody(Body body) {
    	this.body = body;
    }
    
    protected Body getBody() {
    	return body;
    }
    
    @Override
	public float getX() {
    	return body.getPosition().x;
    }
    
    @Override
	public float getY() {
    	return body.getPosition().y;
    }

}