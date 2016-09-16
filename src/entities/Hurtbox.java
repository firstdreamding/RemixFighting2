package entities;

import java.awt.Rectangle;

public class Hurtbox extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int dmg, w, h, knockback, x, y;
	private Entity e;

	Hurtbox(Entity e, int dmg, int w, int h, int knockback, int x, int y) {
		this.dmg = dmg;
		this.w = w;
		this.h = h;
		this.knockback = knockback;
		this.x = x;
		this.y = y;
		this.e = e;
	}

	public Entity getEntity() {
		return e;
	}

}
