package pap.ninjaislands.mechanics;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Audio {
	
	public Clip loadAudio(String som){
		Clip c = null;
		
		File file = new File("res/"+som);
	
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			c = AudioSystem.getClip();
			c.open(ais);
			
			if(som == "zombie.wav" || som == "background.wav" || som == "saltar.wav"){
				FloatControl gainControl = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(-10.0f); // Reduzir volume por 10 decibeis.
			}
		
			if(som == "oceano.wav" || som == "sword.wav"){
				FloatControl gainControl = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(-17.0f); // Reduzir volume por 10 decibeis.
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return c;
	}
	
}
