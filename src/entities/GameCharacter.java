package entities;

import java.util.List;

import utils.FileUtils;

public class GameCharacter {

	public String name;
	public int attackStrength, defenseStrength;
	public int speed;
	public int health;

	public GameCharacter(String file) {
		deserialize(file);
	}

	private void deserialize(String file) {
		List<String> lines = FileUtils.readLinesFromFile(file);

		name = lines.get(0);
		attackStrength = Integer.parseInt(lines.get(1));
		defenseStrength = Integer.parseInt(lines.get(2));
		speed = Integer.parseInt(lines.get(3));
		health = Integer.parseInt(lines.get(4));
	}

}
