package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import entities.GameCharacter;
import entities.Player;
import graphics.Screen;
import graphics.Texture;
import graphics.Window;
import physics.Gravity;
import utils.FileUtils;

public class Main {

	public Main() throws Exception {

	}

	Player p1;
	Texture bg = new Texture("/res/sprites/stage1.png", 960, 540);
	SoundPlayer sp = new SoundPlayer();
	private List<GameCharacter> characters = new ArrayList<GameCharacter>();

	KeyListener mainListen = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int in = e.getKeyCode();
			long now = System.currentTimeMillis();
			if (in == KeyMap.p1Up) {
				if (p1.getJumps() > 0 && now > p1.getLastJumped() + p1.getJumpLength()) {
					p1.jump(9);
				}
			} else if (in == KeyMap.p1Right) {
				p1.setDir(1);
				p1.setXvel(10);
			} else if (in == KeyMap.p1Left) {
				p1.setDir(-1);
				p1.setXvel(-10);
			} else if (in == KeyMap.p1BasicAttack) {
				if (now > p1.getLastAttacked() + p1.getJabLag()) {

					p1.setLastAttacked(now);
					try {
						sp.play("/res/sfx/punch.wav");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (int i = 0; i < 5; i++) {
						p1.setT(i, 0);
						p1.setX(p1.getX() + 5);
						pause(40);
					}
					pause(50);
					for (int i = 4; i >= 0; i--) {
						p1.setT(i, 0);
						p1.setX(p1.getX() - 5);
						pause(40);
					}
				}
			} else if (in == KeyMap.p1SpecialAttack) {
				try {
					sp.play("/res/sfx/star.wav");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			int in = e.getKeyCode();
			if (in == KeyMap.p1Left) {
				if (p1.getDir() < 0) {
					p1.setXvel(0);
				}

			}
			if (in == KeyMap.p1Right) {
				if (p1.getDir() > 0) {
					p1.setXvel(0);
				}
			}

		}

	};

	public void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void render(Screen screen) {
		screen.drawTexture(0, 0, bg);
		screen.drawTexture(p1.getX(), p1.getY(), p1.getTexture());
		// screen.drawRect(0, 500, 500, 1, 0x000000);
		// screen.drawRect(50, 50, 256, 31, 0);
		screen.fillRect(51, 51, 255, 30, 0x000000);
	}

	private void loadCharacters() {
		String basePath = "src/res/characters/";
		for (String line : FileUtils.readLinesFromFile(basePath + "characters.txt")) {
			characters.add(new GameCharacter(basePath + line + ".txt"));
		}
	}

	private void printCharacters() {
		System.out.println("Characters:\n");
		int i = 1;
		for (GameCharacter c : characters) {
			System.out.println("Character #" + i++);
			System.out.println(c.name);
			System.out.println("\tAttack: " + c.attackStrength);
			System.out.println("\tDefense: " + c.defenseStrength);
			System.out.println("\tSpeed: " + c.speed);
			System.out.println("\tHealth: " + c.health);
			System.out.println("\tJab lag: " + c.jabLag);
			System.out.println("\tJump lag: " + c.jumpLag);
			System.out.println();
		}
	}

	private void loop() throws InterruptedException {
		KeyMap.init();

		Window window = new Window("Game", 960, 540);
		window.addKeyListener(mainListen);
		window.show();
		Screen screen = window.getScreen();
		Gravity g = new Gravity();
		loadCharacters();
		printCharacters();
		p1 = new Player(1, 50, 0, 120, 160, characters.get(0));
		int dx = (int) (1000 / 60);
		g.addEntity(p1);
		while (true) {

			// screen = window.getScreen();
			p1.update();
			screen.clear(0xffffff);
			g.update();
			this.render(screen);

			window.update();
			// p1.setY(535);

			Thread.sleep(dx);

		}
	}

	public static void main(String[] args) throws Exception {

		Main game = new Main();
		game.loop();

	}

}