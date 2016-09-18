package entities;

import java.util.List;

import graphics.SpriteSheet;
import graphics.Texture;
import utils.FileUtils;

public class GameCharacter {

	public String name;
	public int attackStrength, defenseStrength, health, speed, jabLag, jumpLag;
	public SpriteSheet sheet;
	public Texture t;

	public GameCharacter(String file) {
		deserialize(file);
	}

	private int toInt(String s) {
		return Integer.parseInt(s);
	}

	private void deserialize(String file) {
		List<String> lines = FileUtils.readLinesFromFile(file);

		name = lines.get(0);
		attackStrength = toInt(lines.get(1));
		defenseStrength = toInt(lines.get(2));
		speed = toInt(lines.get(3));
		health = toInt(lines.get(4));
		jabLag = toInt(lines.get(5));
		jumpLag = toInt(lines.get(6));
	}

}
