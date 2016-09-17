package main;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyMap {
	public static int p1Up = KeyEvent.VK_UP;
	public static int p1Down = KeyEvent.VK_DOWN;
	public static int p1Left = KeyEvent.VK_LEFT;
	public static int p1Right = KeyEvent.VK_RIGHT;
	public static int p1BasicAttack = KeyEvent.VK_M;
	public static int p2Up = KeyEvent.VK_W;
	public static int p2Down = KeyEvent.VK_S;
	public static int p2Left = KeyEvent.VK_A;
	public static int p2Right = KeyEvent.VK_D;
	public static int p2BasicAttack = KeyEvent.VK_E;

	// private static int[] p1Keys = new int[] { p1Up, p1Down, p1Left, p1Right, p1BasicAttack };
	// private static int[] p2Keys = new int[] { p2Up, p2Down, p2Left, p2Right, p2BasicAttack };
	
	private static Map<String, Integer> p1Keys = new HashMap<String, Integer>();
	private static Map<String, Integer> p2Keys = new HashMap<String, Integer>();

	public static void init() {
		p1Keys.put("up", p1Up);
		p1Keys.put("down", p1Down);
		p1Keys.put("left", p1Left);
		p1Keys.put("right", p1Right);
		p1Keys.put("basicAttack", p1BasicAttack);
		
		p2Keys.put("up", p2Up);
		p2Keys.put("down", p2Down);
		p2Keys.put("left", p2Left);
		p2Keys.put("right", p2Right);
		p2Keys.put("basicAttack", p2BasicAttack);
	}
	
	public static Map<String, Integer> getKeyMapping(int playerID) {
		switch (playerID) {
			case 0:	return p1Keys;
			case 1:	return p2Keys;
		}
		return null;
	}

}
