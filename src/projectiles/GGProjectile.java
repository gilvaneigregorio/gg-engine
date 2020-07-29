package projectiles;

import utils.PVector;
import graphics.GGSprite;

/**
* Projectile
* 
* @author Gilvanei Gregorio
* @version 1.1
*/
public class GGProjectile extends GGSprite{
	
    public PVector vectorVelocity;
    public float velocityPro;
    public PVector addVelocity;
    public float angleDegress;
    
    private GGSprite update;
    private GGSprite draw;
    /**
     * Projective constructor
     * 
     * @param float x
     * @param float y
     * @param float width
     * @param float height
     * @param ProjectileUpdate update
     * @param ProjectileDraw draw
     * */
    public GGProjectile(GGSprite parent, float x, float y, float width, float height, float velocity, PVector addVelocity,
    		float angleDegress, GGSprite update, GGSprite draw) {
        super(x, y, width, height);
        this.parent = parent;
        
        this.velocityPro = velocity;
        this.angleDegress = angleDegress;
        this.addVelocity = addVelocity;
        
        this.update = update;
        this.draw = draw;
        
        this.update.parent = this;
        this.draw.parent = this;
        
    	angleRadian = (float)Math.toRadians(angleDegress);
        
        vectorVelocity = new PVector((float)(velocity * Math.sin(angleRadian)),
                (float)-(velocity * Math.cos(angleRadian)));
        
        vectorVelocity.x += addVelocity.x;
        vectorVelocity.y += addVelocity.y;
    }

    /** 
     * Update,call component responsible to update position and states of projective
     * 
     * @param int difTime
     */
    @Override
    public void update(int difTime) {    	
        update.update(difTime);
        draw.update(difTime);
        
        oldPosition = new PVector(position);
    }

    /** 
     * Render,call component responsible to render and draw of projectile
     */
    @Override
    public void render() {
        draw.render();
    }

	@Override
	public void deadAction() {
		
	}
}