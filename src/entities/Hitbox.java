package entities;

import java.awt.Rectangle;

public class Hitbox extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int dmg, w, h, knockback, x, y;
	public long duration;
	public long timeStarted;
	/** Hitbox entity
	 * 
	 * @param dmg Damage dealt by hitbox
	 * @param w Width of hitbox
	 * @param h Height of hitbox
	 * @param knockback Knockback of hitbox
	 * @param x X coordinate of hitbox
	 * @param y Y coordinate of hitbox
	 * @param duration Duration hitbox lasts till self-destruct
	 */
	Hitbox(int dmg, int w, int h, int knockback, int x, int y, int duration) {
		this.dmg = dmg;
		this.w = w;
		this.h = h;
		this.knockback = knockback;
		this.x = x;
		this.y = y;
		this.duration = duration;
		timeStarted = System.currentTimeMillis();

	}

}
