package entities;

import java.util.List;

import graphics.SpriteSheet;
import graphics.Texture;
import utils.FileUtils;

public class GameCharacter {

	public String name;
	public int attackStrength, defenseStrength, health, speed, jumps, jabLag, jumpLag, sheetW, sheetH, sheetDivX,
			sheetDivY, kickDamage, jabDamage, kickLag,width,height;
	public SpriteSheet sheet;
	public Texture t;

	public GameCharacter(String file) {
		deserialize(file);
		generateTextures();
	}

	private int toInt(String s) {
		return Integer.parseInt(s);
	}

	private void generateTextures() {
		t = new Texture("/res/sprites/" + name.toLowerCase() + ".png", sheetW, sheetH);
		sheet = new SpriteSheet(t, sheetDivX, sheetDivY);
	}

	private void deserialize(String file) {
		List<String> lines = FileUtils.readLinesFromFile(file);

		name = lines.get(0);
		sheetW = toInt(lines.get(1));
		sheetH = toInt(lines.get(2));
		sheetDivX = toInt(lines.get(3));
		sheetDivY = toInt(lines.get(4));
		attackStrength = toInt(lines.get(5));
		defenseStrength = toInt(lines.get(6));
		speed = toInt(lines.get(7));
		health = toInt(lines.get(8));
		jumps = toInt(lines.get(9));
		jabLag = toInt(lines.get(10));
		jumpLag = toInt(lines.get(11));
		kickLag = toInt(lines.get(12));
		jabDamage = toInt(lines.get(13));
		kickDamage = toInt(lines.get(14));
		width=toInt(lines.get(15));
		height=toInt(lines.get(16));
		
		

	}

}
