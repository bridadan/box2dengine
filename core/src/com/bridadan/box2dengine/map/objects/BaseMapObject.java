package com.bridadan.box2dengine.map.objects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;

public class BaseMapObject extends MapObject {
	float x, y;
	float originX, originY;
	float angle;
	
	boolean isDrawable = true;
	TextureRegion textureRegion;
	// TODO Maybe replace TextureRegion with a TextureAtlas?
	
	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}
	
	public TextureRegion getTextureRegion() {
		return textureRegion;
	}

	public void setTextureRegion(TextureRegion textureRegion) {
		this.textureRegion = textureRegion;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setOriginX(float originX) {
		this.originX = originX;
	}

	public void setOriginY(float originY) {
		this.originY = originY;
	}

	public void setDrawable(boolean isDrawable) {
		this.isDrawable = isDrawable;
	}

	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getOriginX() {
		return originX;
	}
	
	public float getOriginY() {
		return originY;
	}
	
	public boolean isDrawable() {
		return isDrawable;
	}
}
