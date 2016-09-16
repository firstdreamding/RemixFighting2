package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entities.Player;
import graphics.Screen;
import graphics.SpriteSheet;
import graphics.Texture;
import graphics.Window;
import physics.Gravity;

public class Main {

	public Main() throws Exception {

	}

	ClassLoader cl = getClass().getClassLoader();
	Texture t = new Texture("/res/penguin.png", 800, 800);
	SpriteSheet tp = new SpriteSheet(t, 160, 160);

	Player p1 = new Player(50, 0, 200, 50, tp.getTexture(0
			, 0), 1,2,450,450);
	Texture bg = new Texture("/res/bg.png", 960, 540);

	KeyListener mainListen = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int in = e.getKeyCode();
			long now=System.currentTimeMillis();
			if (in == KeyMap.p1Up)
				if (p1.getJumps()>0&&now>p1.getLastJumped()+p1.getJumpLength()) {
					p1.jump(9);
				}
			if (in == KeyMap.p1BasicAttack) {
				// p1.setYvel(-9);
				for (int i = 0; i < 5; i++) {
					p1.setT(tp.getTexture(i, 0));
					p1.setX(p1.getX() + 5);
					pause(40);
				}
				pause(50);
				for (int i = 4; i >= 0; i--) {
					p1.setT(tp.getTexture(i, 0));
					p1.setX(p1.getX() - 5);
					pause(40);
				}

			}
			// else if(){}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

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
		screen.drawRect(0, 526, 500, 1, 000000000);

	}

	private void loop() throws InterruptedException {
		Window window = new Window("Game", 960, 540);
		window.addKeyListener(mainListen);
		window.show();
		Screen screen = window.getScreen();
		Gravity g = new Gravity();
		int dx = (int) (1000 / 60);
		g.addEntity(p1);
		while (true) {

			// screen = window.getScreen();
			p1.update();
			screen.clear(255255255);
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
