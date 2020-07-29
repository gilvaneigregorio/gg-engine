package graphics;

import java.awt.geom.Rectangle2D;

import utils.PVector;

/**
* Sprite, abstract class. Sprite is a most simple strut of game.
* 
* @author Gilvanei Gregorio
* @version 1.2
*/
public abstract class GGSprite {
    
	/** Position in scene */
    public PVector position;
    /** Position in scene in last cycle */
    public PVector oldPosition;
    
    /** Dimensions of scene in axis x*/
    public float width;
    /** Dimensions of scene in axis y*/
    public float height;
    
    /** Angle in radiant */
    public float angleRadian;
    
    /** collision box of sprite to do collide*/
    public Rectangle2D.Float collisionBox;
    
    /** death or alive in scene */
    private boolean active;
    
    /** solid */
    public boolean solid;
    
    /** If have parent */
    public GGSprite parent;
    
    public int layerScene;
    
	public float currentMoveSpeed;
	public PVector velocity;
	public float maxforce;

    /**
     * Sprite constructor
     * 
     * @param float x
     * @param float y
     * @param float width
     * @param float height
     * */
    public GGSprite(float x, float y, float width, float height){
        this.position = new PVector	(x, y);
        this.width = width;
        this.height = height;
        
        this.collisionBox = new Rectangle2D.Float (x, y, width, height);
        
        this.active = true;
        this.parent = null;
    }
    
    public abstract void deadAction();
    
    public boolean getActive(){
    	return active;
    }
    
    public void setActive(boolean active){
    	this.active = active;
    	if(!active){
    		deadAction();
    	}
    }
    
    /**
     * Sprite empty constructor
     * */
    public GGSprite(){

    }
    
    public abstract void update(int difTime);
    public abstract void render();
}