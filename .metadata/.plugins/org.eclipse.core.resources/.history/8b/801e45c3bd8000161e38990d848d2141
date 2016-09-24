package entities;

import java.util.ArrayList;

public class HitboxController {
	private ArrayList<Hitbox> hitboxes = new ArrayList<>();
	private ArrayList<Hurtbox> hurtboxes = new ArrayList<>();
	private ArrayList<Hitbox> removeThese = new ArrayList<>();
	/**
	 * Checks if hitboxes and hurtboxes are intersecting
	 * 
	 */
	int removeSize;

	public void update() {
		removeSize = removeThese.size();
		for (int i = 0; i < removeSize; i++) {
			hitboxes.remove(removeThese.get(0));
			removeThese.remove(0);
		}
		for (Hitbox h : hitboxes) {
			for (Hurtbox hurt : hurtboxes) {

				if (h.intersects(hurt)) {
					hurt.getEntity().addHealth(-1 * h.dmg);
					removeThese.add(h);
				}

			}

		}

	}

	public void addHitbox(Hitbox b) {
		hitboxes.add(b);
	}

	public void removehurtbox(Hitbox b) {
		hurtboxes.remove(b);
	}

	public void addhurtbox(Hurtbox b) {
		hurtboxes.add(b);
	}

	public void removehurtbox(Hurtbox b) {
		hurtboxes.remove(b);
	}
}
