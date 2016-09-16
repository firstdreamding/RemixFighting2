package entities;

import graphics.Texture;

public class Player extends Entity {

	public int specialbar = 0;
	public int dir;
	public int totalJumps;
	public int jumps;
	public int jabLength;
	public int jumpLength;
	public long lastAttacked = 0;
	public long lastJumped = 0;

	public Player(int x, int y, int w, int h, Texture s, int dir, int totalJumps, int jabLength, int jumpLength) {
		super(x, y, w, h, s);
		this.dir = dir;
		this.jabLength = jabLength;
		this.jumpLength = jumpLength;
		this.totalJumps = totalJumps;
		jumps = totalJumps;
		// TODO Auto-generated constructor stub
	}

	public void update() {
		x = x + xvel;
		y = y + yvel;
		if (!inAir) {
			jumps = totalJumps;
		}
	}

	public void lessJump() {
		jumps = jumps - 1;
	}

	public int getSpecialbar() {
		return specialbar;
	}

	public void jump(int i) {
		setYvel(-i);
		jumps--;
		setInAir(true);
	}

	public void setSpecialbar(int specialbar) {
		this.specialbar = specialbar;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getJumps() {
		return jumps;
	}

	public void setJumps(int jumps) {
		this.jumps = jumps;
	}

	public long getLastAttacked() {
		return lastAttacked;
	}

	public void setLastAttacked(long lastAttacked) {
		this.lastAttacked = lastAttacked;
	}

	public long getLastJumped() {
		return lastJumped;
	}

	public void setLastJumped(long lastJumped) {
		this.lastJumped = lastJumped;
	}

	public int getJabLength() {
		return jabLength;
	}

	public int getJumpLength() {
		return jumpLength;
	}

}
