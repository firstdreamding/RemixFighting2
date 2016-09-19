package main;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {
public void play(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
	AudioInputStream stream = AudioSystem.getAudioInputStream(this.getClass().getResource(path));
	Clip c = AudioSystem.getClip();
	c.open(stream);
	c.start();
	
	
	
	
}
}
