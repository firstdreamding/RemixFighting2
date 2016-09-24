package entities;

import graphics.Texture;

/** Any players, mobs, or simple entities with postion, speed and health */
public class Entity {
	public int x, y, xvel, yvel = 0;
	public Texture sprite;
	public int w, h;
	public int health = 100;
	public boolean inAir=false;
	/**
	 * Constructor for entity
	 * 
	 * 
	 * @param x
	 *            X coordinate for entity
	 * @param y
	 *            Y coordinate for entity
	 * @param s
	 *            Sprite for entity
	 * @param w
	 *            Width of entity
	 * @param h
	 *            Height of entity
	 */
	public Entity(int x, int y, int w, int h, Texture s) {
		this.sprite = s;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;

	}

	/**
	 * Adds or removes health from entity
	 * 
	 * @param i
	 *            Amount added: can be negative.
	 * 
	 */
	public void addHealth(int i) {
		health += i;
	}

	public Texture getTexture() {
		return sprite;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getXvel() {
		return xvel;
	}

	public void setXvel(int xvel) {
		this.xvel = xvel;
	}

	public int getYvel() {
		return yvel;
	}

	public void setYvel(int yvel) {
		this.yvel = yvel;
	}

	/** Moves entity up by yvel */
	public void up() {
		y = y - yvel;
	}

	/** Moves entity down by yvel */
	public void down() {
		y = y + yvel;
	}

	/** Moves entity left by xvel */
	public void left() {
		x = x - xvel;
	}

	/** Moves entity right by xvel */
	public void right() {
		x = x + xvel;
	}

	/**
	 * Changes yvel
	 * 
	 * @param i
	 *            Amount added to yvel: Can be negative
	 */
	public void yaccell(int i) {
		yvel += i;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void setT(Texture t) {
		this.sprite = t;
	}

	public boolean isInAir() {
		return inAir;
	}

	public void setInAir(boolean inAir) {
		this.inAir = inAir;
	}
}
