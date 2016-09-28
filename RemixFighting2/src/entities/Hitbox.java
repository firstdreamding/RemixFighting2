package entities;

import java.awt.Rectangle;

public class Hitbox extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int dmg, knockback;
	public long duration;
	public long timeStarted;

	/**
	 * Hitbox entity
	 * 
	 * @param dmg
	 *            Damage dealt by hitbox
	 *
	 * @param knockback
	 *            Knockback of hitbox
	 *
	 * @param duration
	 *            Duration hitbox lasts till self-destruct
	 */
	public Hitbox(int dmg, int x, int y, int w, int h, int knockback, int duration) {
		this.dmg = dmg;
		this.width = w;
		this.height = h;
		this.knockback = knockback;
		this.x = x;
		this.y = y;
		this.duration = duration;
		timeStarted = System.currentTimeMillis();

	}

}
