package com.bridadan.box2dengine.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.bridadan.box2dengine.PhysicsStage;
import com.bridadan.box2dengine.map.objects.BaseMapObject;

public class MapActor extends Actor {
	BaseMapObject mapObject;
	
	public MapActor(BaseMapObject mapObject) {
		this.mapObject = mapObject;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		if (mapObject.isDrawable() && mapObject.getTextureRegion() != null) {
			Color color = getColor();
			batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
			batch.draw(mapObject.getTextureRegion(),
				PhysicsStage.toScreenSize(mapObject.getX()) - PhysicsStage.toScreenSize(mapObject.getOriginX()) - mapObject.getTextureRegion().getRegionWidth()/2,
				PhysicsStage.toScreenSize(mapObject.getY()) - PhysicsStage.toScreenSize(mapObject.getOriginY()) - mapObject.getTextureRegion().getRegionWidth()/2,
				PhysicsStage.toScreenSize(mapObject.getOriginX()) + mapObject.getTextureRegion().getRegionWidth()/2,
				PhysicsStage.toScreenSize(mapObject.getOriginY()) + mapObject.getTextureRegion().getRegionHeight()/2,
				mapObject.getTextureRegion().getRegionWidth(),
				mapObject.getTextureRegion().getRegionHeight(),
				1.0f,
				1.0f,
				(float) Math.toDegrees(mapObject.getAngle()));
		}
	}
}
