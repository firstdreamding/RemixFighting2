package entities;

import java.util.ArrayList;

public class HitboxController {
	private ArrayList<Hitbox> p1hitboxes = new ArrayList<>();
	private ArrayList<Hitbox> p2hitboxes = new ArrayList<>();
	private ArrayList<Hurtbox> p1hurtboxes = new ArrayList<>();
	private ArrayList<Hurtbox> p2hurtboxes = new ArrayList<>();
	private ArrayList<Hitbox> removeThese = new ArrayList<>();

	/**
	 * Checks if hitboxes and hurtboxes are intersecting
	 * 
	 */
	int removeSize;
	long now;

	public void update() {
		now = System.currentTimeMillis();
		removeSize = removeThese.size();
		for (int i = 0; i < removeSize; i++) {
			p1hitboxes.remove(removeThese.get(0));
			p2hitboxes.remove(removeThese.get(0));
			removeThese.remove(0);
		}
		for (Hurtbox hurt : p1hurtboxes) {
			hurt.update();
			for (Hitbox hit : p2hitboxes) {
				if (now > hit.duration + hit.timeStarted) {
					removeThese.add(hit);
				} else if (hit.intersects(hurt)) {
					System.out.println(-1 * hit.dmg);
					hurt.getEntity().changeHealth(-1 * hit.dmg);
					System.out.println(hurt.getEntity().health);
					removeThese.add(hit);
				}

			}

		}

	}

	public void addHitbox(Hitbox b, int i) {
		if (i == 1) {
			p1hitboxes.add(b);
		} else {
			p2hitboxes.add(b);
		}

	}

	public void removehurtbox(Hitbox b, int i) {
		if (i == 1)
			p1hitboxes.remove(b);
		else {
			p2hitboxes.remove(b);
		}
	}

	public void addhurtbox(Hurtbox b, int i) {
		if (i == 1)
			p1hurtboxes.add(b);
		else {
			p2hurtboxes.add(b);
		}
	}

	public void removehurtbox(Hurtbox b, int i) {
		if (i == 1)
			p1hurtboxes.remove(b);
		else {
			p2hurtboxes.remove(b);
		}
	}

	public ArrayList<Hitbox> getHitboxes(int i) {
		if (i == 1)
			return p1hitboxes;
		else {
			return p2hitboxes;
		}

	}

	public ArrayList<Hurtbox> getHurtboxes(int i) {
		if (i == 1)
			return p1hurtboxes;
		else {
			return p2hurtboxes;
		}
	}
}
