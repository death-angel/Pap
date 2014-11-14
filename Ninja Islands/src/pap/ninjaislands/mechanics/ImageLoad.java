package pap.ninjaislands.mechanics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoad {
	
	/*
	 * @autor Carlos Almeida
	 */

	public static BufferedImage ilhas;
	public static BufferedImage ninja;
	public static BufferedImage hand_gui;
	public static BufferedImage bow_gui;
	public static BufferedImage sword_gui;
	
	public ImageLoad(){
		try {
			ilhas = ImageIO.read(getClass().getResource("/ilhas.png"));
			ninja = ImageIO.read(getClass().getResource("/ninja.png"));
			hand_gui = ImageIO.read(getClass().getResource("/hand.png"));
			bow_gui = ImageIO.read(getClass().getResource("/bow_stand.png"));
			sword_gui = ImageIO.read(getClass().getResource("/sword.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
