package com.bridadan.box2dengine;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.bridadan.box2dengine.map.PhysicsMap;
import com.bridadan.box2dengine.map.PhysicsMapRenderer;
import com.bridadan.box2dengine.utils.Utils;

public class PhysicsStage extends Stage {

    // This will be our viewport measurements while working with the debug renderer
    private static final float VIEWPORT_WIDTH = 40f;
    private static final float VIEWPORT_HEIGHT = 22.5f;

    protected World world;
    private PhysicsMap map;
    private PhysicsMapRenderer mapRenderer;

    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;

    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;
    
    public static final float WORLD_TO_SCREEN = 32;

    public PhysicsStage() {
    	map = new PhysicsMap();
    	world = map.getWorld();
    	
    	map.addActors(this);
        
    	camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
        
        mapRenderer = new PhysicsMapRenderer(map, getBatch());
        mapRenderer.setView(camera);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        // Fixed timestep
        accumulator += delta;

        while (accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }

        //TODO: Implement interpolation

    }

    @Override
    public void draw() {
        super.draw();
        mapRenderer.render();
        mapRenderer.renderDebug();
    }
    
    @Override
    public void addActor(Actor actor) {
    	super.addActor(actor);
    	
    	/*if (Utils.hasSuperclass(actor.getClass(), PhysicsActor.class)) {
    		((PhysicsActor) actor).addToWorld(world);
    	}*/
    }
    
    public static float toScreenSize(float n) {
    	return n * PhysicsStage.WORLD_TO_SCREEN;
    }

}