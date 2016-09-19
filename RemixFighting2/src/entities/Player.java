package entities;

import java.util.Map;

import graphics.SpriteSheet;
import main.KeyMap;

public class Player extends Entity {

	public int specialbar = 0;
	public int totalJumps;
	public int jumps;
	public long lastAttacked = 0;
	public long lastJumped = 0;
	public int dir;
	private GameCharacter character;
	private int playerID;
	public int jabLag;
	public int jumpLag;
	public SpriteSheet sheet;
	private Map<String, Integer> keys;

	public Player(GameCharacter character, int playerID) {
		super(0, 0, 0, 0, null);
		this.character = character;
		this.playerID = playerID;
		keys = KeyMap.getKeyMapping(playerID);
	}

	public Player(int pid, int x, int y, int w, int h, GameCharacter gc) {
		super(x, y, w, h, gc.sheet.getTexture(0, 0));
		if (pid == 1) {
			dir = 1;
		} else {
			dir = -1;
		}
		playerID = pid;
		character = gc;
		this.totalJumps = character.jumps;
		jumps = totalJumps;
		jumpLag = character.jumpLag;
		jabLag = character.jabLag;
		sheet = character.sheet;

		// TODO Auto-generated constructor stub
	}

	public void update() {
		if (x < 0) {
			x = 0;
		}
		if (x > 960 - w) {
			x = 960 - w;
		}
		x = x + xvel;
		y = y + yvel;
		if (!inAir) {
			jumps = totalJumps;
		}

		// handleInput();
	}

	/*
	 * private void handleInput() { if (Input.isKeyPressed(keys.get("left")) { x
	 * -= xvel; } else if (Input.isKeyPressed(keys.get("right"))) { x += xvel; }
	 * }
	 */
	public void setT(int x, int y) {
		sprite = sheet.getTexture(x, y);

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

	public int getJabLag() {
		return jabLag;
	}

	public int getJumpLength() {
		return jumpLag;
	}

}